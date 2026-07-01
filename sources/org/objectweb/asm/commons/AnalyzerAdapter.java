package org.objectweb.asm.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.ConstantDynamic;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/commons/AnalyzerAdapter.SCL.lombok */
public class AnalyzerAdapter extends MethodVisitor {
    public List<Object> locals;
    public List<Object> stack;
    private List<Label> labels;
    public Map<Object, Object> uninitializedTypes;
    private int maxStack;
    private int maxLocals;
    private String owner;

    public AnalyzerAdapter(String owner, int access, String name, String descriptor, MethodVisitor methodVisitor) {
        this(Opcodes.ASM9, owner, access, name, descriptor, methodVisitor);
        if (getClass() != AnalyzerAdapter.class) {
            throw new IllegalStateException();
        }
    }

    protected AnalyzerAdapter(int api, String owner, int access, String name, String descriptor, MethodVisitor methodVisitor) {
        super(api, methodVisitor);
        this.owner = owner;
        this.locals = new ArrayList();
        this.stack = new ArrayList();
        this.uninitializedTypes = new HashMap();
        if ((access & 8) == 0) {
            if ("<init>".equals(name)) {
                this.locals.add(Opcodes.UNINITIALIZED_THIS);
            } else {
                this.locals.add(owner);
            }
        }
        for (Type argumentType : Type.getArgumentTypes(descriptor)) {
            switch (argumentType.getSort()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    this.locals.add(Opcodes.INTEGER);
                    break;
                case 6:
                    this.locals.add(Opcodes.FLOAT);
                    break;
                case 7:
                    this.locals.add(Opcodes.LONG);
                    this.locals.add(Opcodes.TOP);
                    break;
                case 8:
                    this.locals.add(Opcodes.DOUBLE);
                    this.locals.add(Opcodes.TOP);
                    break;
                case 9:
                    this.locals.add(argumentType.getDescriptor());
                    break;
                case 10:
                    this.locals.add(argumentType.getInternalName());
                    break;
                default:
                    throw new AssertionError();
            }
        }
        this.maxLocals = this.locals.size();
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitFrame(int type, int numLocal, Object[] local, int numStack, Object[] stack) {
        if (type != -1) {
            throw new IllegalArgumentException("AnalyzerAdapter only accepts expanded frames (see ClassReader.EXPAND_FRAMES)");
        }
        super.visitFrame(type, numLocal, local, numStack, stack);
        if (this.locals != null) {
            this.locals.clear();
            this.stack.clear();
        } else {
            this.locals = new ArrayList();
            this.stack = new ArrayList();
        }
        visitFrameTypes(numLocal, local, this.locals);
        visitFrameTypes(numStack, stack, this.stack);
        this.maxLocals = Math.max(this.maxLocals, this.locals.size());
        this.maxStack = Math.max(this.maxStack, this.stack.size());
    }

    private static void visitFrameTypes(int numTypes, Object[] frameTypes, List<Object> result) {
        for (int i = 0; i < numTypes; i++) {
            Object frameType = frameTypes[i];
            result.add(frameType);
            if (frameType == Opcodes.LONG || frameType == Opcodes.DOUBLE) {
                result.add(Opcodes.TOP);
            }
        }
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitInsn(int opcode) {
        super.visitInsn(opcode);
        execute(opcode, 0, null);
        if ((opcode >= 172 && opcode <= 177) || opcode == 191) {
            this.locals = null;
            this.stack = null;
        }
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitIntInsn(int opcode, int operand) {
        super.visitIntInsn(opcode, operand);
        execute(opcode, operand, null);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitVarInsn(int opcode, int var) {
        super.visitVarInsn(opcode, var);
        boolean isLongOrDouble = opcode == 22 || opcode == 24 || opcode == 55 || opcode == 57;
        this.maxLocals = Math.max(this.maxLocals, var + (isLongOrDouble ? 2 : 1));
        execute(opcode, var, null);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitTypeInsn(int opcode, String type) {
        if (opcode == 187) {
            if (this.labels == null) {
                Label label = new Label();
                this.labels = new ArrayList(3);
                this.labels.add(label);
                if (this.mv != null) {
                    this.mv.visitLabel(label);
                }
            }
            Iterator<Label> it = this.labels.iterator();
            while (it.hasNext()) {
                this.uninitializedTypes.put(it.next(), type);
            }
        }
        super.visitTypeInsn(opcode, type);
        execute(opcode, 0, type);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
        super.visitFieldInsn(opcode, owner, name, descriptor);
        execute(opcode, 0, descriptor);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMethodInsn(int opcodeAndSource, String owner, String name, String descriptor, boolean isInterface) {
        Object initializedValue;
        if (this.api < 327680 && (opcodeAndSource & 256) == 0) {
            super.visitMethodInsn(opcodeAndSource, owner, name, descriptor, isInterface);
            return;
        }
        super.visitMethodInsn(opcodeAndSource, owner, name, descriptor, isInterface);
        int opcode = opcodeAndSource & (-257);
        if (this.locals == null) {
            this.labels = null;
            return;
        }
        pop(descriptor);
        if (opcode != 184) {
            Object value = pop();
            if (opcode == 183 && name.equals("<init>")) {
                if (value == Opcodes.UNINITIALIZED_THIS) {
                    initializedValue = this.owner;
                } else {
                    initializedValue = this.uninitializedTypes.get(value);
                }
                for (int i = 0; i < this.locals.size(); i++) {
                    if (this.locals.get(i) == value) {
                        this.locals.set(i, initializedValue);
                    }
                }
                for (int i2 = 0; i2 < this.stack.size(); i2++) {
                    if (this.stack.get(i2) == value) {
                        this.stack.set(i2, initializedValue);
                    }
                }
            }
        }
        pushDescriptor(descriptor);
        this.labels = null;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        super.visitInvokeDynamicInsn(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments);
        if (this.locals == null) {
            this.labels = null;
            return;
        }
        pop(descriptor);
        pushDescriptor(descriptor);
        this.labels = null;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitJumpInsn(int opcode, Label label) {
        super.visitJumpInsn(opcode, label);
        execute(opcode, 0, null);
        if (opcode == 167) {
            this.locals = null;
            this.stack = null;
        }
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLabel(Label label) {
        super.visitLabel(label);
        if (this.labels == null) {
            this.labels = new ArrayList(3);
        }
        this.labels.add(label);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLdcInsn(Object value) {
        super.visitLdcInsn(value);
        if (this.locals == null) {
            this.labels = null;
            return;
        }
        if (value instanceof Integer) {
            push(Opcodes.INTEGER);
        } else if (value instanceof Long) {
            push(Opcodes.LONG);
            push(Opcodes.TOP);
        } else if (value instanceof Float) {
            push(Opcodes.FLOAT);
        } else if (value instanceof Double) {
            push(Opcodes.DOUBLE);
            push(Opcodes.TOP);
        } else if (value instanceof String) {
            push("java/lang/String");
        } else if (value instanceof Type) {
            int sort = ((Type) value).getSort();
            if (sort == 10 || sort == 9) {
                push("java/lang/Class");
            } else if (sort == 11) {
                push("java/lang/invoke/MethodType");
            } else {
                throw new IllegalArgumentException();
            }
        } else if (value instanceof Handle) {
            push("java/lang/invoke/MethodHandle");
        } else if (value instanceof ConstantDynamic) {
            pushDescriptor(((ConstantDynamic) value).getDescriptor());
        } else {
            throw new IllegalArgumentException();
        }
        this.labels = null;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitIincInsn(int var, int increment) {
        super.visitIincInsn(var, increment);
        this.maxLocals = Math.max(this.maxLocals, var + 1);
        execute(Opcodes.IINC, var, null);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        super.visitTableSwitchInsn(min, max, dflt, labels);
        execute(Opcodes.TABLESWITCH, 0, null);
        this.locals = null;
        this.stack = null;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        super.visitLookupSwitchInsn(dflt, keys, labels);
        execute(Opcodes.LOOKUPSWITCH, 0, null);
        this.locals = null;
        this.stack = null;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMultiANewArrayInsn(String descriptor, int numDimensions) {
        super.visitMultiANewArrayInsn(descriptor, numDimensions);
        execute(Opcodes.MULTIANEWARRAY, numDimensions, descriptor);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLocalVariable(String name, String descriptor, String signature, Label start, Label end, int index) {
        char firstDescriptorChar = descriptor.charAt(0);
        this.maxLocals = Math.max(this.maxLocals, index + ((firstDescriptorChar == 'J' || firstDescriptorChar == 'D') ? 2 : 1));
        super.visitLocalVariable(name, descriptor, signature, start, end, index);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMaxs(int maxStack, int maxLocals) {
        if (this.mv != null) {
            this.maxStack = Math.max(this.maxStack, maxStack);
            this.maxLocals = Math.max(this.maxLocals, maxLocals);
            this.mv.visitMaxs(this.maxStack, this.maxLocals);
        }
    }

    private Object get(int local) {
        this.maxLocals = Math.max(this.maxLocals, local + 1);
        return local < this.locals.size() ? this.locals.get(local) : Opcodes.TOP;
    }

    private void set(int local, Object type) {
        this.maxLocals = Math.max(this.maxLocals, local + 1);
        while (local >= this.locals.size()) {
            this.locals.add(Opcodes.TOP);
        }
        this.locals.set(local, type);
    }

    private void push(Object type) {
        this.stack.add(type);
        this.maxStack = Math.max(this.maxStack, this.stack.size());
    }

    private void pushDescriptor(String fieldOrMethodDescriptor) {
        String descriptor = fieldOrMethodDescriptor.charAt(0) == '(' ? Type.getReturnType(fieldOrMethodDescriptor).getDescriptor() : fieldOrMethodDescriptor;
        switch (descriptor.charAt(0)) {
            case 'B':
            case 'C':
            case 'I':
            case 'S':
            case 'Z':
                push(Opcodes.INTEGER);
                return;
            case 'D':
                push(Opcodes.DOUBLE);
                push(Opcodes.TOP);
                return;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'W':
            case 'X':
            case 'Y':
            default:
                throw new AssertionError();
            case 'F':
                push(Opcodes.FLOAT);
                return;
            case 'J':
                push(Opcodes.LONG);
                push(Opcodes.TOP);
                return;
            case 'L':
                push(descriptor.substring(1, descriptor.length() - 1));
                return;
            case 'V':
                return;
            case '[':
                push(descriptor);
                return;
        }
    }

    private Object pop() {
        return this.stack.remove(this.stack.size() - 1);
    }

    private void pop(int numSlots) {
        int size = this.stack.size();
        int end = size - numSlots;
        for (int i = size - 1; i >= end; i--) {
            this.stack.remove(i);
        }
    }

    private void pop(String descriptor) {
        char firstDescriptorChar = descriptor.charAt(0);
        if (firstDescriptorChar != '(') {
            if (firstDescriptorChar == 'J' || firstDescriptorChar == 'D') {
                pop(2);
                return;
            } else {
                pop(1);
                return;
            }
        }
        int numSlots = 0;
        Type[] types = Type.getArgumentTypes(descriptor);
        for (Type type : types) {
            numSlots += type.getSize();
        }
        pop(numSlots);
    }

    private void execute(int opcode, int intArg, String stringArg) {
        Object value2;
        Object value3;
        if (opcode == 168 || opcode == 169) {
            throw new IllegalArgumentException("JSR/RET are not supported");
        }
        if (this.locals == null) {
            this.labels = null;
            return;
        }
        switch (opcode) {
            case 0:
            case 116:
            case 117:
            case 118:
            case 119:
            case Opcodes.I2B /* 145 */:
            case Opcodes.I2C /* 146 */:
            case Opcodes.I2S /* 147 */:
            case Opcodes.GOTO /* 167 */:
            case Opcodes.RETURN /* 177 */:
                break;
            case 1:
                push(Opcodes.NULL);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 16:
            case 17:
                push(Opcodes.INTEGER);
                break;
            case 9:
            case 10:
                push(Opcodes.LONG);
                push(Opcodes.TOP);
                break;
            case 11:
            case 12:
            case 13:
                push(Opcodes.FLOAT);
                break;
            case 14:
            case 15:
                push(Opcodes.DOUBLE);
                push(Opcodes.TOP);
                break;
            case 18:
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
            case Opcodes.JSR /* 168 */:
            case Opcodes.RET /* 169 */:
            case Opcodes.INVOKEVIRTUAL /* 182 */:
            case Opcodes.INVOKESPECIAL /* 183 */:
            case Opcodes.INVOKESTATIC /* 184 */:
            case Opcodes.INVOKEINTERFACE /* 185 */:
            case Opcodes.INVOKEDYNAMIC /* 186 */:
            case 196:
            default:
                throw new IllegalArgumentException("Invalid opcode " + opcode);
            case 21:
            case 23:
            case 25:
                push(get(intArg));
                break;
            case 22:
            case 24:
                push(get(intArg));
                push(Opcodes.TOP);
                break;
            case 46:
            case 51:
            case 52:
            case 53:
            case 96:
            case 100:
            case 104:
            case 108:
            case 112:
            case 120:
            case 122:
            case 124:
            case 126:
            case 128:
            case 130:
            case Opcodes.L2I /* 136 */:
            case Opcodes.D2I /* 142 */:
            case Opcodes.FCMPL /* 149 */:
            case 150:
                pop(2);
                push(Opcodes.INTEGER);
                break;
            case 47:
            case Opcodes.D2L /* 143 */:
                pop(2);
                push(Opcodes.LONG);
                push(Opcodes.TOP);
                break;
            case 48:
            case 98:
            case 102:
            case 106:
            case 110:
            case 114:
            case Opcodes.L2F /* 137 */:
            case Opcodes.D2F /* 144 */:
                pop(2);
                push(Opcodes.FLOAT);
                break;
            case 49:
            case Opcodes.L2D /* 138 */:
                pop(2);
                push(Opcodes.DOUBLE);
                push(Opcodes.TOP);
                break;
            case 50:
                pop(1);
                Object value1 = pop();
                if (value1 instanceof String) {
                    pushDescriptor(((String) value1).substring(1));
                } else if (value1 == Opcodes.NULL) {
                    push(value1);
                } else {
                    push("java/lang/Object");
                }
                break;
            case 54:
            case 56:
            case 58:
                Object value4 = pop();
                set(intArg, value4);
                if (intArg > 0 && ((value3 = get(intArg - 1)) == Opcodes.LONG || value3 == Opcodes.DOUBLE)) {
                    set(intArg - 1, Opcodes.TOP);
                }
                break;
            case 55:
            case 57:
                pop(1);
                Object value5 = pop();
                set(intArg, value5);
                set(intArg + 1, Opcodes.TOP);
                if (intArg > 0 && ((value2 = get(intArg - 1)) == Opcodes.LONG || value2 == Opcodes.DOUBLE)) {
                    set(intArg - 1, Opcodes.TOP);
                }
                break;
            case 79:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
                pop(3);
                break;
            case 80:
            case 82:
                pop(4);
                break;
            case 87:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case Opcodes.TABLESWITCH /* 170 */:
            case Opcodes.LOOKUPSWITCH /* 171 */:
            case Opcodes.IRETURN /* 172 */:
            case Opcodes.FRETURN /* 174 */:
            case Opcodes.ARETURN /* 176 */:
            case Opcodes.ATHROW /* 191 */:
            case Opcodes.MONITORENTER /* 194 */:
            case Opcodes.MONITOREXIT /* 195 */:
            case Opcodes.IFNULL /* 198 */:
            case Opcodes.IFNONNULL /* 199 */:
                pop(1);
                break;
            case 88:
            case Opcodes.IF_ICMPEQ /* 159 */:
            case Opcodes.IF_ICMPNE /* 160 */:
            case Opcodes.IF_ICMPLT /* 161 */:
            case Opcodes.IF_ICMPGE /* 162 */:
            case Opcodes.IF_ICMPGT /* 163 */:
            case Opcodes.IF_ICMPLE /* 164 */:
            case Opcodes.IF_ACMPEQ /* 165 */:
            case Opcodes.IF_ACMPNE /* 166 */:
            case Opcodes.LRETURN /* 173 */:
            case 175:
                pop(2);
                break;
            case 89:
                Object value6 = pop();
                push(value6);
                push(value6);
                break;
            case 90:
                Object value7 = pop();
                Object value8 = pop();
                push(value7);
                push(value8);
                push(value7);
                break;
            case 91:
                Object value9 = pop();
                Object value10 = pop();
                Object value11 = pop();
                push(value9);
                push(value11);
                push(value10);
                push(value9);
                break;
            case 92:
                Object value12 = pop();
                Object value13 = pop();
                push(value13);
                push(value12);
                push(value13);
                push(value12);
                break;
            case 93:
                Object value14 = pop();
                Object value15 = pop();
                Object value16 = pop();
                push(value15);
                push(value14);
                push(value16);
                push(value15);
                push(value14);
                break;
            case 94:
                Object value17 = pop();
                Object value18 = pop();
                Object value19 = pop();
                Object t4 = pop();
                push(value18);
                push(value17);
                push(t4);
                push(value19);
                push(value18);
                push(value17);
                break;
            case 95:
                Object value20 = pop();
                Object value21 = pop();
                push(value20);
                push(value21);
                break;
            case 97:
            case 101:
            case 105:
            case 109:
            case 113:
            case Opcodes.LAND /* 127 */:
            case Opcodes.LOR /* 129 */:
            case Opcodes.LXOR /* 131 */:
                pop(4);
                push(Opcodes.LONG);
                push(Opcodes.TOP);
                break;
            case 99:
            case 103:
            case 107:
            case 111:
            case 115:
                pop(4);
                push(Opcodes.DOUBLE);
                push(Opcodes.TOP);
                break;
            case 121:
            case 123:
            case Opcodes.LUSHR /* 125 */:
                pop(3);
                push(Opcodes.LONG);
                push(Opcodes.TOP);
                break;
            case Opcodes.IINC /* 132 */:
                set(intArg, Opcodes.INTEGER);
                break;
            case Opcodes.I2L /* 133 */:
            case Opcodes.F2L /* 140 */:
                pop(1);
                push(Opcodes.LONG);
                push(Opcodes.TOP);
                break;
            case Opcodes.I2F /* 134 */:
                pop(1);
                push(Opcodes.FLOAT);
                break;
            case Opcodes.I2D /* 135 */:
            case Opcodes.F2D /* 141 */:
                pop(1);
                push(Opcodes.DOUBLE);
                push(Opcodes.TOP);
                break;
            case Opcodes.F2I /* 139 */:
            case Opcodes.ARRAYLENGTH /* 190 */:
            case Opcodes.INSTANCEOF /* 193 */:
                pop(1);
                push(Opcodes.INTEGER);
                break;
            case Opcodes.LCMP /* 148 */:
            case Opcodes.DCMPL /* 151 */:
            case Opcodes.DCMPG /* 152 */:
                pop(4);
                push(Opcodes.INTEGER);
                break;
            case Opcodes.GETSTATIC /* 178 */:
                pushDescriptor(stringArg);
                break;
            case Opcodes.PUTSTATIC /* 179 */:
                pop(stringArg);
                break;
            case 180:
                pop(1);
                pushDescriptor(stringArg);
                break;
            case Opcodes.PUTFIELD /* 181 */:
                pop(stringArg);
                pop();
                break;
            case Opcodes.NEW /* 187 */:
                push(this.labels.get(0));
                break;
            case Opcodes.NEWARRAY /* 188 */:
                pop();
                switch (intArg) {
                    case 4:
                        pushDescriptor("[Z");
                        break;
                    case 5:
                        pushDescriptor("[C");
                        break;
                    case 6:
                        pushDescriptor("[F");
                        break;
                    case 7:
                        pushDescriptor("[D");
                        break;
                    case 8:
                        pushDescriptor("[B");
                        break;
                    case 9:
                        pushDescriptor("[S");
                        break;
                    case 10:
                        pushDescriptor("[I");
                        break;
                    case 11:
                        pushDescriptor("[J");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid array type " + intArg);
                }
                break;
            case Opcodes.ANEWARRAY /* 189 */:
                pop();
                pushDescriptor("[" + Type.getObjectType(stringArg));
                break;
            case Opcodes.CHECKCAST /* 192 */:
                pop();
                pushDescriptor(Type.getObjectType(stringArg).getDescriptor());
                break;
            case Opcodes.MULTIANEWARRAY /* 197 */:
                pop(intArg);
                pushDescriptor(stringArg);
                break;
        }
        this.labels = null;
    }
}
