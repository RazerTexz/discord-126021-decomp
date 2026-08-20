package org.objectweb.asm.tree.analysis;

import java.util.ArrayList;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.IincInsnNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.tree.analysis.Value;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/analysis/Frame.SCL.lombok */
public class Frame<V extends Value> {
    private V returnValue;
    private V[] values;
    private int numLocals;
    private int numStack;

    public Frame(int i, int i2) {
        this.values = (V[]) new Value[i + i2];
        this.numLocals = i;
    }

    public Frame(Frame<? extends V> frame) {
        this(frame.numLocals, frame.values.length - frame.numLocals);
        init(frame);
    }

    public Frame<V> init(Frame<? extends V> frame) {
        this.returnValue = frame.returnValue;
        System.arraycopy(frame.values, 0, this.values, 0, this.values.length);
        this.numStack = frame.numStack;
        return this;
    }

    public void initJumpTarget(int opcode, LabelNode target) {
    }

    public void setReturn(V v) {
        this.returnValue = v;
    }

    public int getLocals() {
        return this.numLocals;
    }

    public int getMaxStackSize() {
        return this.values.length - this.numLocals;
    }

    public V getLocal(int index) {
        if (index >= this.numLocals) {
            throw new IndexOutOfBoundsException("Trying to get an inexistant local variable " + index);
        }
        return this.values[index];
    }

    public void setLocal(int index, V value) {
        if (index >= this.numLocals) {
            throw new IndexOutOfBoundsException("Trying to set an inexistant local variable " + index);
        }
        this.values[index] = value;
    }

    public int getStackSize() {
        return this.numStack;
    }

    public V getStack(int index) {
        return this.values[this.numLocals + index];
    }

    public void setStack(int index, V value) {
        this.values[this.numLocals + index] = value;
    }

    public void clearStack() {
        this.numStack = 0;
    }

    public V pop() {
        if (this.numStack == 0) {
            throw new IndexOutOfBoundsException("Cannot pop operand off an empty stack.");
        }
        V[] vArr = this.values;
        int i = this.numLocals;
        int i2 = this.numStack - 1;
        this.numStack = i2;
        return vArr[i + i2];
    }

    public void push(V value) {
        if (this.numLocals + this.numStack >= this.values.length) {
            throw new IndexOutOfBoundsException("Insufficient maximum stack size.");
        }
        V[] vArr = this.values;
        int i = this.numLocals;
        int i2 = this.numStack;
        this.numStack = i2 + 1;
        vArr[i + i2] = value;
    }

    public void execute(AbstractInsnNode insn, Interpreter<V> interpreter) throws AnalyzerException {
        Value local;
        switch (insn.getOpcode()) {
            case 0:
            case Opcodes.GOTO /* 167 */:
            case Opcodes.RET /* 169 */:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                push(interpreter.newOperation(insn));
                return;
            case 19:
            case 20:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 196:
            default:
                throw new AnalyzerException(insn, "Illegal opcode " + insn.getOpcode());
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                push(interpreter.copyOperation(insn, getLocal(((VarInsnNode) insn).var)));
                return;
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case Opcodes.LUSHR /* 125 */:
            case 126:
            case Opcodes.LAND /* 127 */:
            case 128:
            case Opcodes.LOR /* 129 */:
            case 130:
            case Opcodes.LXOR /* 131 */:
            case Opcodes.LCMP /* 148 */:
            case Opcodes.FCMPL /* 149 */:
            case 150:
            case Opcodes.DCMPL /* 151 */:
            case Opcodes.DCMPG /* 152 */:
                push(interpreter.binaryOperation(insn, pop(), pop()));
                return;
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
                Value valueCopyOperation = interpreter.copyOperation(insn, pop());
                int var = ((VarInsnNode) insn).var;
                setLocal(var, valueCopyOperation);
                if (valueCopyOperation.getSize() == 2) {
                    setLocal(var + 1, interpreter.newEmptyValue(var + 1));
                }
                if (var > 0 && (local = getLocal(var - 1)) != null && local.getSize() == 2) {
                    setLocal(var - 1, interpreter.newEmptyValue(var - 1));
                    return;
                }
                return;
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
                interpreter.ternaryOperation(insn, pop(), pop(), pop());
                return;
            case 87:
                if (pop().getSize() == 2) {
                    throw new AnalyzerException(insn, "Illegal use of POP");
                }
                return;
            case 88:
                if (pop().getSize() == 1 && pop().getSize() != 1) {
                    throw new AnalyzerException(insn, "Illegal use of POP2");
                }
                return;
            case 89:
                Value valuePop = pop();
                if (valuePop.getSize() != 1) {
                    throw new AnalyzerException(insn, "Illegal use of DUP");
                }
                push(valuePop);
                push(interpreter.copyOperation(insn, valuePop));
                return;
            case 90:
                Value valuePop2 = pop();
                Value valuePop3 = pop();
                if (valuePop2.getSize() != 1 || valuePop3.getSize() != 1) {
                    throw new AnalyzerException(insn, "Illegal use of DUP_X1");
                }
                push(interpreter.copyOperation(insn, valuePop2));
                push(valuePop3);
                push(valuePop2);
                return;
            case 91:
                Value valuePop4 = pop();
                if (valuePop4.getSize() != 1 || !executeDupX2(insn, valuePop4, interpreter)) {
                    throw new AnalyzerException(insn, "Illegal use of DUP_X2");
                }
                return;
            case 92:
                Value valuePop5 = pop();
                if (valuePop5.getSize() == 1) {
                    Value valuePop6 = pop();
                    if (valuePop6.getSize() == 1) {
                        push(valuePop6);
                        push(valuePop5);
                        push(interpreter.copyOperation(insn, valuePop6));
                        push(interpreter.copyOperation(insn, valuePop5));
                        return;
                    }
                    throw new AnalyzerException(insn, "Illegal use of DUP2");
                }
                push(valuePop5);
                push(interpreter.copyOperation(insn, valuePop5));
                return;
            case 93:
                Value valuePop7 = pop();
                if (valuePop7.getSize() == 1) {
                    Value valuePop8 = pop();
                    if (valuePop8.getSize() == 1) {
                        Value valuePop9 = pop();
                        if (valuePop9.getSize() == 1) {
                            push(interpreter.copyOperation(insn, valuePop8));
                            push(interpreter.copyOperation(insn, valuePop7));
                            push(valuePop9);
                            push(valuePop8);
                            push(valuePop7);
                            return;
                        }
                    }
                } else {
                    Value valuePop10 = pop();
                    if (valuePop10.getSize() == 1) {
                        push(interpreter.copyOperation(insn, valuePop7));
                        push(valuePop10);
                        push(valuePop7);
                        return;
                    }
                }
                throw new AnalyzerException(insn, "Illegal use of DUP2_X1");
            case 94:
                Value valuePop11 = pop();
                if (valuePop11.getSize() == 1) {
                    Value valuePop12 = pop();
                    if (valuePop12.getSize() == 1) {
                        Value valuePop13 = pop();
                        if (valuePop13.getSize() == 1) {
                            Value valuePop14 = pop();
                            if (valuePop14.getSize() == 1) {
                                push(interpreter.copyOperation(insn, valuePop12));
                                push(interpreter.copyOperation(insn, valuePop11));
                                push(valuePop14);
                                push(valuePop13);
                                push(valuePop12);
                                push(valuePop11);
                                return;
                            }
                        } else {
                            push(interpreter.copyOperation(insn, valuePop12));
                            push(interpreter.copyOperation(insn, valuePop11));
                            push(valuePop13);
                            push(valuePop12);
                            push(valuePop11);
                            return;
                        }
                    }
                } else if (executeDupX2(insn, valuePop11, interpreter)) {
                    return;
                }
                throw new AnalyzerException(insn, "Illegal use of DUP2_X2");
            case 95:
                Value valuePop15 = pop();
                Value valuePop16 = pop();
                if (valuePop16.getSize() != 1 || valuePop15.getSize() != 1) {
                    throw new AnalyzerException(insn, "Illegal use of SWAP");
                }
                push(interpreter.copyOperation(insn, valuePop15));
                push(interpreter.copyOperation(insn, valuePop16));
                return;
            case 116:
            case 117:
            case 118:
            case 119:
                push(interpreter.unaryOperation(insn, pop()));
                return;
            case Opcodes.IINC /* 132 */:
                int var2 = ((IincInsnNode) insn).var;
                setLocal(var2, interpreter.unaryOperation(insn, getLocal(var2)));
                return;
            case Opcodes.I2L /* 133 */:
            case Opcodes.I2F /* 134 */:
            case Opcodes.I2D /* 135 */:
            case Opcodes.L2I /* 136 */:
            case Opcodes.L2F /* 137 */:
            case Opcodes.L2D /* 138 */:
            case Opcodes.F2I /* 139 */:
            case Opcodes.F2L /* 140 */:
            case Opcodes.F2D /* 141 */:
            case Opcodes.D2I /* 142 */:
            case Opcodes.D2L /* 143 */:
            case Opcodes.D2F /* 144 */:
            case Opcodes.I2B /* 145 */:
            case Opcodes.I2C /* 146 */:
            case Opcodes.I2S /* 147 */:
                push(interpreter.unaryOperation(insn, pop()));
                return;
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
                interpreter.unaryOperation(insn, pop());
                return;
            case Opcodes.IF_ICMPEQ /* 159 */:
            case Opcodes.IF_ICMPNE /* 160 */:
            case Opcodes.IF_ICMPLT /* 161 */:
            case Opcodes.IF_ICMPGE /* 162 */:
            case Opcodes.IF_ICMPGT /* 163 */:
            case Opcodes.IF_ICMPLE /* 164 */:
            case Opcodes.IF_ACMPEQ /* 165 */:
            case Opcodes.IF_ACMPNE /* 166 */:
            case Opcodes.PUTFIELD /* 181 */:
                interpreter.binaryOperation(insn, pop(), pop());
                return;
            case Opcodes.JSR /* 168 */:
                push(interpreter.newOperation(insn));
                return;
            case Opcodes.TABLESWITCH /* 170 */:
            case Opcodes.LOOKUPSWITCH /* 171 */:
                interpreter.unaryOperation(insn, pop());
                return;
            case Opcodes.IRETURN /* 172 */:
            case Opcodes.LRETURN /* 173 */:
            case Opcodes.FRETURN /* 174 */:
            case 175:
            case Opcodes.ARETURN /* 176 */:
                Value valuePop17 = pop();
                interpreter.unaryOperation(insn, valuePop17);
                interpreter.returnOperation(insn, valuePop17, this.returnValue);
                return;
            case Opcodes.RETURN /* 177 */:
                if (this.returnValue != null) {
                    throw new AnalyzerException(insn, "Incompatible return type");
                }
                return;
            case Opcodes.GETSTATIC /* 178 */:
                push(interpreter.newOperation(insn));
                return;
            case Opcodes.PUTSTATIC /* 179 */:
                interpreter.unaryOperation(insn, pop());
                return;
            case 180:
                push(interpreter.unaryOperation(insn, pop()));
                return;
            case Opcodes.INVOKEVIRTUAL /* 182 */:
            case Opcodes.INVOKESPECIAL /* 183 */:
            case Opcodes.INVOKESTATIC /* 184 */:
            case Opcodes.INVOKEINTERFACE /* 185 */:
                executeInvokeInsn(insn, ((MethodInsnNode) insn).desc, interpreter);
                return;
            case Opcodes.INVOKEDYNAMIC /* 186 */:
                executeInvokeInsn(insn, ((InvokeDynamicInsnNode) insn).desc, interpreter);
                return;
            case Opcodes.NEW /* 187 */:
                push(interpreter.newOperation(insn));
                return;
            case Opcodes.NEWARRAY /* 188 */:
            case Opcodes.ANEWARRAY /* 189 */:
            case Opcodes.ARRAYLENGTH /* 190 */:
                push(interpreter.unaryOperation(insn, pop()));
                return;
            case Opcodes.ATHROW /* 191 */:
                interpreter.unaryOperation(insn, pop());
                return;
            case Opcodes.CHECKCAST /* 192 */:
            case Opcodes.INSTANCEOF /* 193 */:
                push(interpreter.unaryOperation(insn, pop()));
                return;
            case Opcodes.MONITORENTER /* 194 */:
            case Opcodes.MONITOREXIT /* 195 */:
                interpreter.unaryOperation(insn, pop());
                return;
            case Opcodes.MULTIANEWARRAY /* 197 */:
                ArrayList arrayList = new ArrayList();
                for (int i = ((MultiANewArrayInsnNode) insn).dims; i > 0; i--) {
                    arrayList.add(0, pop());
                }
                push(interpreter.naryOperation(insn, arrayList));
                return;
            case Opcodes.IFNULL /* 198 */:
            case Opcodes.IFNONNULL /* 199 */:
                interpreter.unaryOperation(insn, pop());
                return;
        }
    }

    private boolean executeDupX2(AbstractInsnNode insn, V value1, Interpreter<V> interpreter) throws AnalyzerException {
        Value valuePop = pop();
        if (valuePop.getSize() == 1) {
            Value valuePop2 = pop();
            if (valuePop2.getSize() == 1) {
                push(interpreter.copyOperation(insn, value1));
                push(valuePop2);
                push(valuePop);
                push(value1);
                return true;
            }
            return false;
        }
        push(interpreter.copyOperation(insn, value1));
        push(valuePop);
        push(value1);
        return true;
    }

    private void executeInvokeInsn(AbstractInsnNode insn, String methodDescriptor, Interpreter<V> interpreter) throws AnalyzerException {
        ArrayList arrayList = new ArrayList();
        for (int i = Type.getArgumentTypes(methodDescriptor).length; i > 0; i--) {
            arrayList.add(0, pop());
        }
        if (insn.getOpcode() != 184 && insn.getOpcode() != 186) {
            arrayList.add(0, pop());
        }
        if (Type.getReturnType(methodDescriptor) == Type.VOID_TYPE) {
            interpreter.naryOperation(insn, arrayList);
        } else {
            push(interpreter.naryOperation(insn, arrayList));
        }
    }

    public boolean merge(Frame<? extends V> frame, Interpreter<V> interpreter) throws AnalyzerException {
        if (this.numStack != frame.numStack) {
            throw new AnalyzerException(null, "Incompatible stack heights");
        }
        boolean z2 = false;
        for (int i = 0; i < this.numLocals + this.numStack; i++) {
            Value valueMerge = interpreter.merge(this.values[i], frame.values[i]);
            if (!valueMerge.equals(this.values[i])) {
                ((V[]) this.values)[i] = valueMerge;
                z2 = true;
            }
        }
        return z2;
    }

    public boolean merge(Frame<? extends V> frame, boolean[] localsUsed) {
        boolean changed = false;
        for (int i = 0; i < this.numLocals; i++) {
            if (!localsUsed[i] && !this.values[i].equals(frame.values[i])) {
                this.values[i] = frame.values[i];
                changed = true;
            }
        }
        return changed;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getLocals(); i++) {
            stringBuilder.append(getLocal(i));
        }
        stringBuilder.append(' ');
        for (int i2 = 0; i2 < getStackSize(); i2++) {
            stringBuilder.append(getStack(i2).toString());
        }
        return stringBuilder.toString();
    }
}
