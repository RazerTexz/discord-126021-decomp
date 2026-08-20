package org.objectweb.asm.tree.analysis;

import java.util.List;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/analysis/BasicVerifier.SCL.lombok */
public class BasicVerifier extends BasicInterpreter {
    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter, org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ void returnOperation(AbstractInsnNode abstractInsnNode, Value value, Value value2) throws AnalyzerException {
        returnOperation(abstractInsnNode, (BasicValue) value, (BasicValue) value2);
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter, org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value naryOperation(AbstractInsnNode abstractInsnNode, List list) throws AnalyzerException {
        return naryOperation(abstractInsnNode, (List<? extends BasicValue>) list);
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter, org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value ternaryOperation(AbstractInsnNode abstractInsnNode, Value value, Value value2, Value value3) throws AnalyzerException {
        return ternaryOperation(abstractInsnNode, (BasicValue) value, (BasicValue) value2, (BasicValue) value3);
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter, org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value binaryOperation(AbstractInsnNode abstractInsnNode, Value value, Value value2) throws AnalyzerException {
        return binaryOperation(abstractInsnNode, (BasicValue) value, (BasicValue) value2);
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter, org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value unaryOperation(AbstractInsnNode abstractInsnNode, Value value) throws AnalyzerException {
        return unaryOperation(abstractInsnNode, (BasicValue) value);
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter, org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value copyOperation(AbstractInsnNode abstractInsnNode, Value value) throws AnalyzerException {
        return copyOperation(abstractInsnNode, (BasicValue) value);
    }

    public BasicVerifier() {
        super(Opcodes.ASM9);
        if (getClass() != BasicVerifier.class) {
            throw new IllegalStateException();
        }
    }

    protected BasicVerifier(int api) {
        super(api);
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter
    public BasicValue copyOperation(AbstractInsnNode insn, BasicValue value) throws AnalyzerException {
        Value expected;
        switch (insn.getOpcode()) {
            case 21:
            case 54:
                expected = BasicValue.INT_VALUE;
                break;
            case 22:
            case 55:
                expected = BasicValue.LONG_VALUE;
                break;
            case 23:
            case 56:
                expected = BasicValue.FLOAT_VALUE;
                break;
            case 24:
            case 57:
                expected = BasicValue.DOUBLE_VALUE;
                break;
            case 25:
                if (!value.isReference()) {
                    throw new AnalyzerException(insn, null, "an object reference", value);
                }
                return value;
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
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            default:
                return value;
            case 58:
                if (!value.isReference() && !BasicValue.RETURNADDRESS_VALUE.equals(value)) {
                    throw new AnalyzerException(insn, null, "an object reference or a return address", value);
                }
                return value;
        }
        if (!expected.equals(value)) {
            throw new AnalyzerException(insn, null, expected, value);
        }
        return value;
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter
    public BasicValue unaryOperation(AbstractInsnNode insn, BasicValue value) throws AnalyzerException {
        BasicValue expected;
        switch (insn.getOpcode()) {
            case 116:
            case Opcodes.IINC /* 132 */:
            case Opcodes.I2L /* 133 */:
            case Opcodes.I2F /* 134 */:
            case Opcodes.I2D /* 135 */:
            case Opcodes.I2B /* 145 */:
            case Opcodes.I2C /* 146 */:
            case Opcodes.I2S /* 147 */:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case Opcodes.TABLESWITCH /* 170 */:
            case Opcodes.LOOKUPSWITCH /* 171 */:
            case Opcodes.IRETURN /* 172 */:
            case Opcodes.NEWARRAY /* 188 */:
            case Opcodes.ANEWARRAY /* 189 */:
                expected = BasicValue.INT_VALUE;
                break;
            case 117:
            case Opcodes.L2I /* 136 */:
            case Opcodes.L2F /* 137 */:
            case Opcodes.L2D /* 138 */:
            case Opcodes.LRETURN /* 173 */:
                expected = BasicValue.LONG_VALUE;
                break;
            case 118:
            case Opcodes.F2I /* 139 */:
            case Opcodes.F2L /* 140 */:
            case Opcodes.F2D /* 141 */:
            case Opcodes.FRETURN /* 174 */:
                expected = BasicValue.FLOAT_VALUE;
                break;
            case 119:
            case Opcodes.D2I /* 142 */:
            case Opcodes.D2L /* 143 */:
            case Opcodes.D2F /* 144 */:
            case 175:
                expected = BasicValue.DOUBLE_VALUE;
                break;
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
            case Opcodes.IF_ICMPEQ /* 159 */:
            case Opcodes.IF_ICMPNE /* 160 */:
            case Opcodes.IF_ICMPLT /* 161 */:
            case Opcodes.IF_ICMPGE /* 162 */:
            case Opcodes.IF_ICMPGT /* 163 */:
            case Opcodes.IF_ICMPLE /* 164 */:
            case Opcodes.IF_ACMPEQ /* 165 */:
            case Opcodes.IF_ACMPNE /* 166 */:
            case Opcodes.GOTO /* 167 */:
            case Opcodes.JSR /* 168 */:
            case Opcodes.RET /* 169 */:
            case Opcodes.RETURN /* 177 */:
            case Opcodes.GETSTATIC /* 178 */:
            case Opcodes.PUTFIELD /* 181 */:
            case Opcodes.INVOKEVIRTUAL /* 182 */:
            case Opcodes.INVOKESPECIAL /* 183 */:
            case Opcodes.INVOKESTATIC /* 184 */:
            case Opcodes.INVOKEINTERFACE /* 185 */:
            case Opcodes.INVOKEDYNAMIC /* 186 */:
            case Opcodes.NEW /* 187 */:
            case 196:
            case Opcodes.MULTIANEWARRAY /* 197 */:
            default:
                throw new AssertionError();
            case Opcodes.ARETURN /* 176 */:
            case Opcodes.ATHROW /* 191 */:
            case Opcodes.CHECKCAST /* 192 */:
            case Opcodes.INSTANCEOF /* 193 */:
            case Opcodes.MONITORENTER /* 194 */:
            case Opcodes.MONITOREXIT /* 195 */:
            case Opcodes.IFNULL /* 198 */:
            case Opcodes.IFNONNULL /* 199 */:
                if (!value.isReference()) {
                    throw new AnalyzerException(insn, null, "an object reference", value);
                }
                return super.unaryOperation(insn, value);
            case Opcodes.PUTSTATIC /* 179 */:
                expected = newValue(Type.getType(((FieldInsnNode) insn).desc));
                break;
            case 180:
                expected = newValue(Type.getObjectType(((FieldInsnNode) insn).owner));
                break;
            case Opcodes.ARRAYLENGTH /* 190 */:
                if (!isArrayValue(value)) {
                    throw new AnalyzerException(insn, null, "an array reference", value);
                }
                return super.unaryOperation(insn, value);
        }
        if (!isSubTypeOf(value, expected)) {
            throw new AnalyzerException(insn, null, expected, value);
        }
        return super.unaryOperation(insn, value);
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter
    public BasicValue binaryOperation(AbstractInsnNode insn, BasicValue value1, BasicValue value2) throws AnalyzerException {
        BasicValue expected1;
        BasicValue expected2;
        switch (insn.getOpcode()) {
            case 46:
                expected1 = newValue(Type.getType("[I"));
                expected2 = BasicValue.INT_VALUE;
                break;
            case 47:
                expected1 = newValue(Type.getType("[J"));
                expected2 = BasicValue.INT_VALUE;
                break;
            case 48:
                expected1 = newValue(Type.getType("[F"));
                expected2 = BasicValue.INT_VALUE;
                break;
            case 49:
                expected1 = newValue(Type.getType("[D"));
                expected2 = BasicValue.INT_VALUE;
                break;
            case 50:
                expected1 = newValue(Type.getType("[Ljava/lang/Object;"));
                expected2 = BasicValue.INT_VALUE;
                break;
            case 51:
                if (isSubTypeOf(value1, newValue(Type.getType("[Z")))) {
                    expected1 = newValue(Type.getType("[Z"));
                } else {
                    expected1 = newValue(Type.getType("[B"));
                }
                expected2 = BasicValue.INT_VALUE;
                break;
            case 52:
                expected1 = newValue(Type.getType("[C"));
                expected2 = BasicValue.INT_VALUE;
                break;
            case 53:
                expected1 = newValue(Type.getType("[S"));
                expected2 = BasicValue.INT_VALUE;
                break;
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
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
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 116:
            case 117:
            case 118:
            case 119:
            case Opcodes.IINC /* 132 */:
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
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case Opcodes.GOTO /* 167 */:
            case Opcodes.JSR /* 168 */:
            case Opcodes.RET /* 169 */:
            case Opcodes.TABLESWITCH /* 170 */:
            case Opcodes.LOOKUPSWITCH /* 171 */:
            case Opcodes.IRETURN /* 172 */:
            case Opcodes.LRETURN /* 173 */:
            case Opcodes.FRETURN /* 174 */:
            case 175:
            case Opcodes.ARETURN /* 176 */:
            case Opcodes.RETURN /* 177 */:
            case Opcodes.GETSTATIC /* 178 */:
            case Opcodes.PUTSTATIC /* 179 */:
            case 180:
            default:
                throw new AssertionError();
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
            case Opcodes.IF_ICMPEQ /* 159 */:
            case Opcodes.IF_ICMPNE /* 160 */:
            case Opcodes.IF_ICMPLT /* 161 */:
            case Opcodes.IF_ICMPGE /* 162 */:
            case Opcodes.IF_ICMPGT /* 163 */:
            case Opcodes.IF_ICMPLE /* 164 */:
                expected1 = BasicValue.INT_VALUE;
                expected2 = BasicValue.INT_VALUE;
                break;
            case 97:
            case 101:
            case 105:
            case 109:
            case 113:
            case Opcodes.LAND /* 127 */:
            case Opcodes.LOR /* 129 */:
            case Opcodes.LXOR /* 131 */:
            case Opcodes.LCMP /* 148 */:
                expected1 = BasicValue.LONG_VALUE;
                expected2 = BasicValue.LONG_VALUE;
                break;
            case 98:
            case 102:
            case 106:
            case 110:
            case 114:
            case Opcodes.FCMPL /* 149 */:
            case 150:
                expected1 = BasicValue.FLOAT_VALUE;
                expected2 = BasicValue.FLOAT_VALUE;
                break;
            case 99:
            case 103:
            case 107:
            case 111:
            case 115:
            case Opcodes.DCMPL /* 151 */:
            case Opcodes.DCMPG /* 152 */:
                expected1 = BasicValue.DOUBLE_VALUE;
                expected2 = BasicValue.DOUBLE_VALUE;
                break;
            case 121:
            case 123:
            case Opcodes.LUSHR /* 125 */:
                expected1 = BasicValue.LONG_VALUE;
                expected2 = BasicValue.INT_VALUE;
                break;
            case Opcodes.IF_ACMPEQ /* 165 */:
            case Opcodes.IF_ACMPNE /* 166 */:
                expected1 = BasicValue.REFERENCE_VALUE;
                expected2 = BasicValue.REFERENCE_VALUE;
                break;
            case Opcodes.PUTFIELD /* 181 */:
                FieldInsnNode fieldInsn = (FieldInsnNode) insn;
                expected1 = newValue(Type.getObjectType(fieldInsn.owner));
                expected2 = newValue(Type.getType(fieldInsn.desc));
                break;
        }
        if (!isSubTypeOf(value1, expected1)) {
            throw new AnalyzerException(insn, "First argument", expected1, value1);
        }
        if (!isSubTypeOf(value2, expected2)) {
            throw new AnalyzerException(insn, "Second argument", expected2, value2);
        }
        if (insn.getOpcode() == 50) {
            return getElementValue(value1);
        }
        return super.binaryOperation(insn, value1, value2);
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter
    public BasicValue ternaryOperation(AbstractInsnNode insn, BasicValue value1, BasicValue value2, BasicValue value3) throws AnalyzerException {
        BasicValue expected1;
        BasicValue expected3;
        switch (insn.getOpcode()) {
            case 79:
                expected1 = newValue(Type.getType("[I"));
                expected3 = BasicValue.INT_VALUE;
                break;
            case 80:
                expected1 = newValue(Type.getType("[J"));
                expected3 = BasicValue.LONG_VALUE;
                break;
            case 81:
                expected1 = newValue(Type.getType("[F"));
                expected3 = BasicValue.FLOAT_VALUE;
                break;
            case 82:
                expected1 = newValue(Type.getType("[D"));
                expected3 = BasicValue.DOUBLE_VALUE;
                break;
            case 83:
                expected1 = value1;
                expected3 = BasicValue.REFERENCE_VALUE;
                break;
            case 84:
                if (isSubTypeOf(value1, newValue(Type.getType("[Z")))) {
                    expected1 = newValue(Type.getType("[Z"));
                } else {
                    expected1 = newValue(Type.getType("[B"));
                }
                expected3 = BasicValue.INT_VALUE;
                break;
            case 85:
                expected1 = newValue(Type.getType("[C"));
                expected3 = BasicValue.INT_VALUE;
                break;
            case 86:
                expected1 = newValue(Type.getType("[S"));
                expected3 = BasicValue.INT_VALUE;
                break;
            default:
                throw new AssertionError();
        }
        if (!isSubTypeOf(value1, expected1)) {
            throw new AnalyzerException(insn, "First argument", "a " + expected1 + " array reference", value1);
        }
        if (!BasicValue.INT_VALUE.equals(value2)) {
            throw new AnalyzerException(insn, "Second argument", BasicValue.INT_VALUE, value2);
        }
        if (!isSubTypeOf(value3, expected3)) {
            throw new AnalyzerException(insn, "Third argument", expected3, value3);
        }
        return null;
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter, org.objectweb.asm.tree.analysis.Interpreter
    public BasicValue naryOperation(AbstractInsnNode insn, List<? extends BasicValue> values) throws AnalyzerException {
        int opcode = insn.getOpcode();
        if (opcode == 197) {
            for (BasicValue value : values) {
                if (!BasicValue.INT_VALUE.equals(value)) {
                    throw new AnalyzerException(insn, null, BasicValue.INT_VALUE, value);
                }
            }
        } else {
            int i = 0;
            int j = 0;
            if (opcode != 184 && opcode != 186) {
                Type owner = Type.getObjectType(((MethodInsnNode) insn).owner);
                i = 0 + 1;
                if (!isSubTypeOf(values.get(0), newValue(owner))) {
                    throw new AnalyzerException(insn, "Method owner", newValue(owner), values.get(0));
                }
            }
            String methodDescriptor = opcode == 186 ? ((InvokeDynamicInsnNode) insn).desc : ((MethodInsnNode) insn).desc;
            Type[] args = Type.getArgumentTypes(methodDescriptor);
            while (i < values.size()) {
                int i2 = j;
                j++;
                BasicValue expected = newValue(args[i2]);
                int i3 = i;
                i++;
                BasicValue actual = values.get(i3);
                if (!isSubTypeOf(actual, expected)) {
                    throw new AnalyzerException(insn, "Argument " + j, expected, actual);
                }
            }
        }
        return super.naryOperation(insn, values);
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter
    public void returnOperation(AbstractInsnNode insn, BasicValue value, BasicValue expected) throws AnalyzerException {
        if (!isSubTypeOf(value, expected)) {
            throw new AnalyzerException(insn, "Incompatible return type", expected, value);
        }
    }

    protected boolean isArrayValue(BasicValue value) {
        return value.isReference();
    }

    protected BasicValue getElementValue(BasicValue objectArrayValue) throws AnalyzerException {
        return BasicValue.REFERENCE_VALUE;
    }

    protected boolean isSubTypeOf(BasicValue value, BasicValue expected) {
        return value.equals(expected);
    }
}
