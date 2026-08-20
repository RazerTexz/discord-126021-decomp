package org.objectweb.asm.tree.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.IincInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LookupSwitchInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TableSwitchInsnNode;
import org.objectweb.asm.tree.TryCatchBlockNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.tree.analysis.Value;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/analysis/Analyzer.SCL.lombok */
public class Analyzer<V extends Value> implements Opcodes {
    private final Interpreter<V> interpreter;
    private InsnList insnList;
    private int insnListSize;
    private List<TryCatchBlockNode>[] handlers;
    private Frame<V>[] frames;
    private Subroutine[] subroutines;
    private boolean[] inInstructionsToProcess;
    private int[] instructionsToProcess;
    private int numInstructionsToProcess;

    public Analyzer(Interpreter<V> interpreter) {
        this.interpreter = interpreter;
    }

    public Frame<V>[] analyze(String owner, MethodNode method) throws AnalyzerException {
        Type catchType;
        if ((method.access & 1280) != 0) {
            this.frames = new Frame[0];
            return this.frames;
        }
        this.insnList = method.instructions;
        this.insnListSize = this.insnList.size();
        this.handlers = new List[this.insnListSize];
        this.frames = new Frame[this.insnListSize];
        this.subroutines = new Subroutine[this.insnListSize];
        this.inInstructionsToProcess = new boolean[this.insnListSize];
        this.instructionsToProcess = new int[this.insnListSize];
        this.numInstructionsToProcess = 0;
        for (int i = 0; i < method.tryCatchBlocks.size(); i++) {
            TryCatchBlockNode tryCatchBlock = method.tryCatchBlocks.get(i);
            int startIndex = this.insnList.indexOf(tryCatchBlock.start);
            int endIndex = this.insnList.indexOf(tryCatchBlock.end);
            for (int j = startIndex; j < endIndex; j++) {
                List<TryCatchBlockNode> insnHandlers = this.handlers[j];
                if (insnHandlers == null) {
                    insnHandlers = new ArrayList();
                    this.handlers[j] = insnHandlers;
                }
                insnHandlers.add(tryCatchBlock);
            }
        }
        Subroutine main = new Subroutine(null, method.maxLocals, null);
        List<AbstractInsnNode> jsrInsns = new ArrayList<>();
        findSubroutine(0, main, jsrInsns);
        Map<LabelNode, Subroutine> jsrSubroutines = new HashMap<>();
        while (!jsrInsns.isEmpty()) {
            JumpInsnNode jsrInsn = (JumpInsnNode) jsrInsns.remove(0);
            Subroutine subroutine = jsrSubroutines.get(jsrInsn.label);
            if (subroutine == null) {
                Subroutine subroutine2 = new Subroutine(jsrInsn.label, method.maxLocals, jsrInsn);
                jsrSubroutines.put(jsrInsn.label, subroutine2);
                findSubroutine(this.insnList.indexOf(jsrInsn.label), subroutine2, jsrInsns);
            } else {
                subroutine.callers.add(jsrInsn);
            }
        }
        for (int i2 = 0; i2 < this.insnListSize; i2++) {
            if (this.subroutines[i2] != null && this.subroutines[i2].start == null) {
                this.subroutines[i2] = null;
            }
        }
        Frame<V> currentFrame = computeInitialFrame(owner, method);
        merge(0, currentFrame, null);
        init(owner, method);
        while (this.numInstructionsToProcess > 0) {
            int[] iArr = this.instructionsToProcess;
            int i3 = this.numInstructionsToProcess - 1;
            this.numInstructionsToProcess = i3;
            int insnIndex = iArr[i3];
            Frame<V> oldFrame = this.frames[insnIndex];
            Subroutine subroutine3 = this.subroutines[insnIndex];
            this.inInstructionsToProcess[insnIndex] = false;
            AbstractInsnNode insnNode = null;
            try {
                insnNode = method.instructions.get(insnIndex);
                int insnOpcode = insnNode.getOpcode();
                int insnType = insnNode.getType();
                if (insnType == 8 || insnType == 15 || insnType == 14) {
                    merge(insnIndex + 1, oldFrame, subroutine3);
                    newControlFlowEdge(insnIndex, insnIndex + 1);
                } else {
                    currentFrame.init(oldFrame).execute(insnNode, this.interpreter);
                    subroutine3 = subroutine3 == null ? null : new Subroutine(subroutine3);
                    if (insnNode instanceof JumpInsnNode) {
                        JumpInsnNode jumpInsn = (JumpInsnNode) insnNode;
                        if (insnOpcode != 167 && insnOpcode != 168) {
                            currentFrame.initJumpTarget(insnOpcode, null);
                            merge(insnIndex + 1, currentFrame, subroutine3);
                            newControlFlowEdge(insnIndex, insnIndex + 1);
                        }
                        int jumpInsnIndex = this.insnList.indexOf(jumpInsn.label);
                        currentFrame.initJumpTarget(insnOpcode, jumpInsn.label);
                        if (insnOpcode == 168) {
                            merge(jumpInsnIndex, currentFrame, new Subroutine(jumpInsn.label, method.maxLocals, jumpInsn));
                        } else {
                            merge(jumpInsnIndex, currentFrame, subroutine3);
                        }
                        newControlFlowEdge(insnIndex, jumpInsnIndex);
                    } else if (insnNode instanceof LookupSwitchInsnNode) {
                        LookupSwitchInsnNode lookupSwitchInsn = (LookupSwitchInsnNode) insnNode;
                        int targetInsnIndex = this.insnList.indexOf(lookupSwitchInsn.dflt);
                        currentFrame.initJumpTarget(insnOpcode, lookupSwitchInsn.dflt);
                        merge(targetInsnIndex, currentFrame, subroutine3);
                        newControlFlowEdge(insnIndex, targetInsnIndex);
                        for (int i4 = 0; i4 < lookupSwitchInsn.labels.size(); i4++) {
                            LabelNode label = lookupSwitchInsn.labels.get(i4);
                            int targetInsnIndex2 = this.insnList.indexOf(label);
                            currentFrame.initJumpTarget(insnOpcode, label);
                            merge(targetInsnIndex2, currentFrame, subroutine3);
                            newControlFlowEdge(insnIndex, targetInsnIndex2);
                        }
                    } else if (insnNode instanceof TableSwitchInsnNode) {
                        TableSwitchInsnNode tableSwitchInsn = (TableSwitchInsnNode) insnNode;
                        int targetInsnIndex3 = this.insnList.indexOf(tableSwitchInsn.dflt);
                        currentFrame.initJumpTarget(insnOpcode, tableSwitchInsn.dflt);
                        merge(targetInsnIndex3, currentFrame, subroutine3);
                        newControlFlowEdge(insnIndex, targetInsnIndex3);
                        for (int i5 = 0; i5 < tableSwitchInsn.labels.size(); i5++) {
                            LabelNode label2 = tableSwitchInsn.labels.get(i5);
                            currentFrame.initJumpTarget(insnOpcode, label2);
                            int targetInsnIndex4 = this.insnList.indexOf(label2);
                            merge(targetInsnIndex4, currentFrame, subroutine3);
                            newControlFlowEdge(insnIndex, targetInsnIndex4);
                        }
                    } else if (insnOpcode == 169) {
                        if (subroutine3 == null) {
                            throw new AnalyzerException(insnNode, "RET instruction outside of a subroutine");
                        }
                        for (int i6 = 0; i6 < subroutine3.callers.size(); i6++) {
                            JumpInsnNode caller = subroutine3.callers.get(i6);
                            int jsrInsnIndex = this.insnList.indexOf(caller);
                            if (this.frames[jsrInsnIndex] != null) {
                                merge(jsrInsnIndex + 1, this.frames[jsrInsnIndex], currentFrame, this.subroutines[jsrInsnIndex], subroutine3.localsUsed);
                                newControlFlowEdge(insnIndex, jsrInsnIndex + 1);
                            }
                        }
                    } else if (insnOpcode != 191 && (insnOpcode < 172 || insnOpcode > 177)) {
                        if (subroutine3 != null) {
                            if (insnNode instanceof VarInsnNode) {
                                int var = ((VarInsnNode) insnNode).var;
                                subroutine3.localsUsed[var] = true;
                                if (insnOpcode == 22 || insnOpcode == 24 || insnOpcode == 55 || insnOpcode == 57) {
                                    subroutine3.localsUsed[var + 1] = true;
                                }
                            } else if (insnNode instanceof IincInsnNode) {
                                subroutine3.localsUsed[((IincInsnNode) insnNode).var] = true;
                            }
                        }
                        merge(insnIndex + 1, currentFrame, subroutine3);
                        newControlFlowEdge(insnIndex, insnIndex + 1);
                    }
                }
                List<TryCatchBlockNode> insnHandlers2 = this.handlers[insnIndex];
                if (insnHandlers2 != null) {
                    for (TryCatchBlockNode tryCatchBlock2 : insnHandlers2) {
                        if (tryCatchBlock2.type == null) {
                            catchType = Type.getObjectType("java/lang/Throwable");
                        } else {
                            catchType = Type.getObjectType(tryCatchBlock2.type);
                        }
                        if (newControlFlowExceptionEdge(insnIndex, tryCatchBlock2)) {
                            Frame<V> handler = newFrame(oldFrame);
                            handler.clearStack();
                            handler.push(this.interpreter.newExceptionValue(tryCatchBlock2, handler, catchType));
                            merge(this.insnList.indexOf(tryCatchBlock2.handler), handler, subroutine3);
                        }
                    }
                }
            } catch (RuntimeException e) {
                throw new AnalyzerException(insnNode, "Error at instruction " + insnIndex + ": " + e.getMessage(), e);
            } catch (AnalyzerException e2) {
                throw new AnalyzerException(e2.node, "Error at instruction " + insnIndex + ": " + e2.getMessage(), e2);
            }
        }
        return this.frames;
    }

    private void findSubroutine(int insnIndex, Subroutine subroutine, List<AbstractInsnNode> jsrInsns) throws AnalyzerException {
        ArrayList<Integer> instructionIndicesToProcess = new ArrayList<>();
        instructionIndicesToProcess.add(Integer.valueOf(insnIndex));
        while (!instructionIndicesToProcess.isEmpty()) {
            int currentInsnIndex = instructionIndicesToProcess.remove(instructionIndicesToProcess.size() - 1).intValue();
            if (currentInsnIndex < 0 || currentInsnIndex >= this.insnListSize) {
                throw new AnalyzerException(null, "Execution can fall off the end of the code");
            }
            if (this.subroutines[currentInsnIndex] == null) {
                this.subroutines[currentInsnIndex] = new Subroutine(subroutine);
                AbstractInsnNode currentInsn = this.insnList.get(currentInsnIndex);
                if (currentInsn instanceof JumpInsnNode) {
                    if (currentInsn.getOpcode() == 168) {
                        jsrInsns.add(currentInsn);
                    } else {
                        JumpInsnNode jumpInsn = (JumpInsnNode) currentInsn;
                        instructionIndicesToProcess.add(Integer.valueOf(this.insnList.indexOf(jumpInsn.label)));
                    }
                } else if (currentInsn instanceof TableSwitchInsnNode) {
                    TableSwitchInsnNode tableSwitchInsn = (TableSwitchInsnNode) currentInsn;
                    findSubroutine(this.insnList.indexOf(tableSwitchInsn.dflt), subroutine, jsrInsns);
                    for (int i = tableSwitchInsn.labels.size() - 1; i >= 0; i--) {
                        LabelNode labelNode = tableSwitchInsn.labels.get(i);
                        instructionIndicesToProcess.add(Integer.valueOf(this.insnList.indexOf(labelNode)));
                    }
                } else if (currentInsn instanceof LookupSwitchInsnNode) {
                    LookupSwitchInsnNode lookupSwitchInsn = (LookupSwitchInsnNode) currentInsn;
                    findSubroutine(this.insnList.indexOf(lookupSwitchInsn.dflt), subroutine, jsrInsns);
                    for (int i2 = lookupSwitchInsn.labels.size() - 1; i2 >= 0; i2--) {
                        LabelNode labelNode2 = lookupSwitchInsn.labels.get(i2);
                        instructionIndicesToProcess.add(Integer.valueOf(this.insnList.indexOf(labelNode2)));
                    }
                }
                List<TryCatchBlockNode> insnHandlers = this.handlers[currentInsnIndex];
                if (insnHandlers != null) {
                    for (TryCatchBlockNode tryCatchBlock : insnHandlers) {
                        instructionIndicesToProcess.add(Integer.valueOf(this.insnList.indexOf(tryCatchBlock.handler)));
                    }
                }
                switch (currentInsn.getOpcode()) {
                    case Opcodes.GOTO /* 167 */:
                    case Opcodes.RET /* 169 */:
                    case Opcodes.TABLESWITCH /* 170 */:
                    case Opcodes.LOOKUPSWITCH /* 171 */:
                    case Opcodes.IRETURN /* 172 */:
                    case Opcodes.LRETURN /* 173 */:
                    case Opcodes.FRETURN /* 174 */:
                    case 175:
                    case Opcodes.ARETURN /* 176 */:
                    case Opcodes.RETURN /* 177 */:
                    case Opcodes.ATHROW /* 191 */:
                        break;
                    case Opcodes.JSR /* 168 */:
                    case Opcodes.GETSTATIC /* 178 */:
                    case Opcodes.PUTSTATIC /* 179 */:
                    case 180:
                    case Opcodes.PUTFIELD /* 181 */:
                    case Opcodes.INVOKEVIRTUAL /* 182 */:
                    case Opcodes.INVOKESPECIAL /* 183 */:
                    case Opcodes.INVOKESTATIC /* 184 */:
                    case Opcodes.INVOKEINTERFACE /* 185 */:
                    case Opcodes.INVOKEDYNAMIC /* 186 */:
                    case Opcodes.NEW /* 187 */:
                    case Opcodes.NEWARRAY /* 188 */:
                    case Opcodes.ANEWARRAY /* 189 */:
                    case Opcodes.ARRAYLENGTH /* 190 */:
                    default:
                        instructionIndicesToProcess.add(Integer.valueOf(currentInsnIndex + 1));
                        break;
                }
            }
        }
    }

    private Frame<V> computeInitialFrame(String owner, MethodNode method) {
        Frame<V> frame = newFrame(method.maxLocals, method.maxStack);
        int currentLocal = 0;
        boolean isInstanceMethod = (method.access & 8) == 0;
        if (isInstanceMethod) {
            Type ownerType = Type.getObjectType(owner);
            frame.setLocal(0, this.interpreter.newParameterValue(isInstanceMethod, 0, ownerType));
            currentLocal = 0 + 1;
        }
        Type[] argumentTypes = Type.getArgumentTypes(method.desc);
        for (Type argumentType : argumentTypes) {
            frame.setLocal(currentLocal, this.interpreter.newParameterValue(isInstanceMethod, currentLocal, argumentType));
            currentLocal++;
            if (argumentType.getSize() == 2) {
                frame.setLocal(currentLocal, this.interpreter.newEmptyValue(currentLocal));
                currentLocal++;
            }
        }
        while (currentLocal < method.maxLocals) {
            frame.setLocal(currentLocal, this.interpreter.newEmptyValue(currentLocal));
            currentLocal++;
        }
        frame.setReturn(this.interpreter.newReturnTypeValue(Type.getReturnType(method.desc)));
        return frame;
    }

    public Frame<V>[] getFrames() {
        return this.frames;
    }

    public List<TryCatchBlockNode> getHandlers(int insnIndex) {
        return this.handlers[insnIndex];
    }

    protected void init(String owner, MethodNode method) throws AnalyzerException {
    }

    protected Frame<V> newFrame(int numLocals, int numStack) {
        return new Frame<>(numLocals, numStack);
    }

    protected Frame<V> newFrame(Frame<? extends V> frame) {
        return new Frame<>(frame);
    }

    protected void newControlFlowEdge(int insnIndex, int successorIndex) {
    }

    protected boolean newControlFlowExceptionEdge(int insnIndex, int successorIndex) {
        return true;
    }

    protected boolean newControlFlowExceptionEdge(int insnIndex, TryCatchBlockNode tryCatchBlock) {
        return newControlFlowExceptionEdge(insnIndex, this.insnList.indexOf(tryCatchBlock.handler));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void merge(int insnIndex, Frame<V> frame, Subroutine subroutine) throws AnalyzerException {
        boolean changed;
        Frame<V> oldFrame = this.frames[insnIndex];
        if (oldFrame == null) {
            this.frames[insnIndex] = newFrame(frame);
            changed = true;
        } else {
            changed = oldFrame.merge(frame, this.interpreter);
        }
        Subroutine oldSubroutine = this.subroutines[insnIndex];
        if (oldSubroutine == null) {
            if (subroutine != null) {
                this.subroutines[insnIndex] = new Subroutine(subroutine);
                changed = true;
            }
        } else if (subroutine != null) {
            changed |= oldSubroutine.merge(subroutine);
        }
        if (changed && !this.inInstructionsToProcess[insnIndex]) {
            this.inInstructionsToProcess[insnIndex] = true;
            int[] iArr = this.instructionsToProcess;
            int i = this.numInstructionsToProcess;
            this.numInstructionsToProcess = i + 1;
            iArr[i] = insnIndex;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void merge(int insnIndex, Frame<V> frameBeforeJsr, Frame<V> frame, Subroutine subroutineBeforeJsr, boolean[] localsUsed) throws AnalyzerException {
        boolean changed;
        frame.merge(frameBeforeJsr, localsUsed);
        Frame<V> oldFrame = this.frames[insnIndex];
        if (oldFrame == null) {
            this.frames[insnIndex] = newFrame(frame);
            changed = true;
        } else {
            changed = oldFrame.merge(frame, this.interpreter);
        }
        Subroutine oldSubroutine = this.subroutines[insnIndex];
        if (oldSubroutine != null && subroutineBeforeJsr != null) {
            changed |= oldSubroutine.merge(subroutineBeforeJsr);
        }
        if (changed && !this.inInstructionsToProcess[insnIndex]) {
            this.inInstructionsToProcess[insnIndex] = true;
            int[] iArr = this.instructionsToProcess;
            int i = this.numInstructionsToProcess;
            this.numInstructionsToProcess = i + 1;
            iArr[i] = insnIndex;
        }
    }
}
