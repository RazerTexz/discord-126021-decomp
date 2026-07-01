package org.objectweb.asm.commons;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LocalVariableNode;
import org.objectweb.asm.tree.LookupSwitchInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TableSwitchInsnNode;
import org.objectweb.asm.tree.TryCatchBlockNode;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/commons/JSRInlinerAdapter.SCL.lombok */
public class JSRInlinerAdapter extends MethodNode implements Opcodes {
    private final BitSet mainSubroutineInsns;
    private final Map<LabelNode, BitSet> subroutinesInsns;
    final BitSet sharedSubroutineInsns;

    public JSRInlinerAdapter(MethodVisitor methodVisitor, int access, String name, String descriptor, String signature, String[] exceptions) {
        this(Opcodes.ASM9, methodVisitor, access, name, descriptor, signature, exceptions);
        if (getClass() != JSRInlinerAdapter.class) {
            throw new IllegalStateException();
        }
    }

    protected JSRInlinerAdapter(int api, MethodVisitor methodVisitor, int access, String name, String descriptor, String signature, String[] exceptions) {
        super(api, access, name, descriptor, signature, exceptions);
        this.mainSubroutineInsns = new BitSet();
        this.subroutinesInsns = new HashMap();
        this.sharedSubroutineInsns = new BitSet();
        this.mv = methodVisitor;
    }

    @Override // org.objectweb.asm.tree.MethodNode, org.objectweb.asm.MethodVisitor
    public void visitJumpInsn(int opcode, Label label) {
        super.visitJumpInsn(opcode, label);
        LabelNode labelNode = ((JumpInsnNode) this.instructions.getLast()).label;
        if (opcode == 168 && !this.subroutinesInsns.containsKey(labelNode)) {
            this.subroutinesInsns.put(labelNode, new BitSet());
        }
    }

    @Override // org.objectweb.asm.tree.MethodNode, org.objectweb.asm.MethodVisitor
    public void visitEnd() {
        if (!this.subroutinesInsns.isEmpty()) {
            findSubroutinesInsns();
            emitCode();
        }
        if (this.mv != null) {
            accept(this.mv);
        }
    }

    private void findSubroutinesInsns() {
        BitSet visitedInsns = new BitSet();
        findSubroutineInsns(0, this.mainSubroutineInsns, visitedInsns);
        for (Map$Entry<LabelNode, BitSet> entry : this.subroutinesInsns.entrySet()) {
            LabelNode jsrLabelNode = entry.getKey();
            BitSet subroutineInsns = entry.getValue();
            findSubroutineInsns(this.instructions.indexOf(jsrLabelNode), subroutineInsns, visitedInsns);
        }
    }

    private void findSubroutineInsns(int startInsnIndex, BitSet subroutineInsns, BitSet visitedInsns) {
        boolean applicableHandlerFound;
        findReachableInsns(startInsnIndex, subroutineInsns, visitedInsns);
        do {
            applicableHandlerFound = false;
            for (TryCatchBlockNode tryCatchBlockNode : this.tryCatchBlocks) {
                int handlerIndex = this.instructions.indexOf(tryCatchBlockNode.handler);
                if (!subroutineInsns.get(handlerIndex)) {
                    int startIndex = this.instructions.indexOf(tryCatchBlockNode.start);
                    int endIndex = this.instructions.indexOf(tryCatchBlockNode.end);
                    int firstSubroutineInsnAfterTryCatchStart = subroutineInsns.nextSetBit(startIndex);
                    if (firstSubroutineInsnAfterTryCatchStart >= startIndex && firstSubroutineInsnAfterTryCatchStart < endIndex) {
                        findReachableInsns(handlerIndex, subroutineInsns, visitedInsns);
                        applicableHandlerFound = true;
                    }
                }
            }
        } while (applicableHandlerFound);
    }

    private void findReachableInsns(int insnIndex, BitSet subroutineInsns, BitSet visitedInsns) {
        for (int currentInsnIndex = insnIndex; currentInsnIndex < this.instructions.size() && !subroutineInsns.get(currentInsnIndex); currentInsnIndex++) {
            subroutineInsns.set(currentInsnIndex);
            if (visitedInsns.get(currentInsnIndex)) {
                this.sharedSubroutineInsns.set(currentInsnIndex);
            }
            visitedInsns.set(currentInsnIndex);
            AbstractInsnNode currentInsnNode = this.instructions.get(currentInsnIndex);
            if (currentInsnNode.getType() == 7 && currentInsnNode.getOpcode() != 168) {
                JumpInsnNode jumpInsnNode = (JumpInsnNode) currentInsnNode;
                findReachableInsns(this.instructions.indexOf(jumpInsnNode.label), subroutineInsns, visitedInsns);
            } else if (currentInsnNode.getType() == 11) {
                TableSwitchInsnNode tableSwitchInsnNode = (TableSwitchInsnNode) currentInsnNode;
                findReachableInsns(this.instructions.indexOf(tableSwitchInsnNode.dflt), subroutineInsns, visitedInsns);
                for (LabelNode labelNode : tableSwitchInsnNode.labels) {
                    findReachableInsns(this.instructions.indexOf(labelNode), subroutineInsns, visitedInsns);
                }
            } else if (currentInsnNode.getType() == 12) {
                LookupSwitchInsnNode lookupSwitchInsnNode = (LookupSwitchInsnNode) currentInsnNode;
                findReachableInsns(this.instructions.indexOf(lookupSwitchInsnNode.dflt), subroutineInsns, visitedInsns);
                for (LabelNode labelNode2 : lookupSwitchInsnNode.labels) {
                    findReachableInsns(this.instructions.indexOf(labelNode2), subroutineInsns, visitedInsns);
                }
            }
            switch (this.instructions.get(currentInsnIndex).getOpcode()) {
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
                    return;
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
                    break;
            }
        }
    }

    private void emitCode() {
        LinkedList<JSRInlinerAdapter$Instantiation> worklist = new LinkedList<>();
        worklist.add(new JSRInlinerAdapter$Instantiation(this, null, this.mainSubroutineInsns));
        InsnList newInstructions = new InsnList();
        List<TryCatchBlockNode> newTryCatchBlocks = new ArrayList<>();
        List<LocalVariableNode> newLocalVariables = new ArrayList<>();
        while (!worklist.isEmpty()) {
            JSRInlinerAdapter$Instantiation instantiation = worklist.removeFirst();
            emitInstantiation(instantiation, worklist, newInstructions, newTryCatchBlocks, newLocalVariables);
        }
        this.instructions = newInstructions;
        this.tryCatchBlocks = newTryCatchBlocks;
        this.localVariables = newLocalVariables;
    }

    private void emitInstantiation(JSRInlinerAdapter$Instantiation instantiation, List<JSRInlinerAdapter$Instantiation> worklist, InsnList newInstructions, List<TryCatchBlockNode> newTryCatchBlocks, List<LocalVariableNode> newLocalVariables) {
        LabelNode previousLabelNode = null;
        for (int i = 0; i < this.instructions.size(); i++) {
            AbstractInsnNode insnNode = this.instructions.get(i);
            if (insnNode.getType() == 8) {
                LabelNode labelNode = (LabelNode) insnNode;
                LabelNode clonedLabelNode = instantiation.getClonedLabel(labelNode);
                if (clonedLabelNode != previousLabelNode) {
                    newInstructions.add(clonedLabelNode);
                    previousLabelNode = clonedLabelNode;
                }
            } else if (instantiation.findOwner(i) != instantiation) {
                continue;
            } else if (insnNode.getOpcode() == 169) {
                LabelNode retLabel = null;
                JSRInlinerAdapter$Instantiation jSRInlinerAdapter$Instantiation = instantiation;
                while (true) {
                    JSRInlinerAdapter$Instantiation retLabelOwner = jSRInlinerAdapter$Instantiation;
                    if (retLabelOwner == null) {
                        break;
                    }
                    if (retLabelOwner.subroutineInsns.get(i)) {
                        retLabel = retLabelOwner.returnLabel;
                    }
                    jSRInlinerAdapter$Instantiation = retLabelOwner.parent;
                }
                if (retLabel == null) {
                    throw new IllegalArgumentException("Instruction #" + i + " is a RET not owned by any subroutine");
                }
                newInstructions.add(new JumpInsnNode(Opcodes.GOTO, retLabel));
            } else if (insnNode.getOpcode() == 168) {
                LabelNode jsrLabelNode = ((JumpInsnNode) insnNode).label;
                BitSet subroutineInsns = this.subroutinesInsns.get(jsrLabelNode);
                JSRInlinerAdapter$Instantiation newInstantiation = new JSRInlinerAdapter$Instantiation(this, instantiation, subroutineInsns);
                LabelNode clonedJsrLabelNode = newInstantiation.getClonedLabelForJumpInsn(jsrLabelNode);
                newInstructions.add(new InsnNode(1));
                newInstructions.add(new JumpInsnNode(Opcodes.GOTO, clonedJsrLabelNode));
                newInstructions.add(newInstantiation.returnLabel);
                worklist.add(newInstantiation);
            } else {
                newInstructions.add(insnNode.clone(instantiation));
            }
        }
        for (TryCatchBlockNode tryCatchBlockNode : this.tryCatchBlocks) {
            LabelNode start = instantiation.getClonedLabel(tryCatchBlockNode.start);
            LabelNode end = instantiation.getClonedLabel(tryCatchBlockNode.end);
            if (start != end) {
                LabelNode handler = instantiation.getClonedLabelForJumpInsn(tryCatchBlockNode.handler);
                if (start == null || end == null || handler == null) {
                    throw new AssertionError("Internal error!");
                }
                newTryCatchBlocks.add(new TryCatchBlockNode(start, end, handler, tryCatchBlockNode.type));
            }
        }
        for (LocalVariableNode localVariableNode : this.localVariables) {
            LabelNode start2 = instantiation.getClonedLabel(localVariableNode.start);
            LabelNode end2 = instantiation.getClonedLabel(localVariableNode.end);
            if (start2 != end2) {
                newLocalVariables.add(new LocalVariableNode(localVariableNode.name, localVariableNode.desc, localVariableNode.signature, start2, end2, localVariableNode.index));
            }
        }
    }
}
