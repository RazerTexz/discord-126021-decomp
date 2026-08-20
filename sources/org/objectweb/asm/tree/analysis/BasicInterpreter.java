package org.objectweb.asm.tree.analysis;

import java.util.List;
import org.objectweb.asm.ConstantDynamic;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/analysis/BasicInterpreter.SCL.lombok */
public class BasicInterpreter extends Interpreter<BasicValue> implements Opcodes {
    public static final Type NULL_TYPE = Type.getObjectType("null");

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value merge(Value value, Value value2) {
        return merge((BasicValue) value, (BasicValue) value2);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ void returnOperation(AbstractInsnNode abstractInsnNode, Value value, Value value2) throws AnalyzerException {
        returnOperation(abstractInsnNode, (BasicValue) value, (BasicValue) value2);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value naryOperation(AbstractInsnNode abstractInsnNode, List list) throws AnalyzerException {
        return naryOperation(abstractInsnNode, (List<? extends BasicValue>) list);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value ternaryOperation(AbstractInsnNode abstractInsnNode, Value value, Value value2, Value value3) throws AnalyzerException {
        return ternaryOperation(abstractInsnNode, (BasicValue) value, (BasicValue) value2, (BasicValue) value3);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value binaryOperation(AbstractInsnNode abstractInsnNode, Value value, Value value2) throws AnalyzerException {
        return binaryOperation(abstractInsnNode, (BasicValue) value, (BasicValue) value2);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value unaryOperation(AbstractInsnNode abstractInsnNode, Value value) throws AnalyzerException {
        return unaryOperation(abstractInsnNode, (BasicValue) value);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value copyOperation(AbstractInsnNode abstractInsnNode, Value value) throws AnalyzerException {
        return copyOperation(abstractInsnNode, (BasicValue) value);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value newOperation(AbstractInsnNode abstractInsnNode) throws AnalyzerException {
        return newOperation(abstractInsnNode);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value newValue(Type type) {
        return newValue(type);
    }

    public BasicInterpreter() {
        super(Opcodes.ASM9);
        if (getClass() != BasicInterpreter.class) {
            throw new IllegalStateException();
        }
    }

    protected BasicInterpreter(int api) {
        super(api);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public BasicValue newValue(Type type) {
        if (type == null) {
            return BasicValue.UNINITIALIZED_VALUE;
        }
        switch (type.getSort()) {
            case 0:
                return null;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return BasicValue.INT_VALUE;
            case 6:
                return BasicValue.FLOAT_VALUE;
            case 7:
                return BasicValue.LONG_VALUE;
            case 8:
                return BasicValue.DOUBLE_VALUE;
            case 9:
            case 10:
                return BasicValue.REFERENCE_VALUE;
            default:
                throw new AssertionError();
        }
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public BasicValue newOperation(AbstractInsnNode insn) throws AnalyzerException {
        switch (insn.getOpcode()) {
            case 1:
                return newValue(NULL_TYPE);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return BasicValue.INT_VALUE;
            case 9:
            case 10:
                return BasicValue.LONG_VALUE;
            case 11:
            case 12:
            case 13:
                return BasicValue.FLOAT_VALUE;
            case 14:
            case 15:
                return BasicValue.DOUBLE_VALUE;
            case 16:
            case 17:
                return BasicValue.INT_VALUE;
            case 18:
                Object value = ((LdcInsnNode) insn).cst;
                if (value instanceof Integer) {
                    return BasicValue.INT_VALUE;
                }
                if (value instanceof Float) {
                    return BasicValue.FLOAT_VALUE;
                }
                if (value instanceof Long) {
                    return BasicValue.LONG_VALUE;
                }
                if (value instanceof Double) {
                    return BasicValue.DOUBLE_VALUE;
                }
                if (value instanceof String) {
                    return newValue(Type.getObjectType("java/lang/String"));
                }
                if (value instanceof Type) {
                    int sort = ((Type) value).getSort();
                    if (sort == 10 || sort == 9) {
                        return newValue(Type.getObjectType("java/lang/Class"));
                    }
                    if (sort == 11) {
                        return newValue(Type.getObjectType("java/lang/invoke/MethodType"));
                    }
                    throw new AnalyzerException(insn, "Illegal LDC value " + value);
                }
                if (value instanceof Handle) {
                    return newValue(Type.getObjectType("java/lang/invoke/MethodHandle"));
                }
                if (value instanceof ConstantDynamic) {
                    return newValue(Type.getType(((ConstantDynamic) value).getDescriptor()));
                }
                throw new AnalyzerException(insn, "Illegal LDC value " + value);
            case Opcodes.JSR /* 168 */:
                return BasicValue.RETURNADDRESS_VALUE;
            case Opcodes.GETSTATIC /* 178 */:
                return newValue(Type.getType(((FieldInsnNode) insn).desc));
            case Opcodes.NEW /* 187 */:
                return newValue(Type.getObjectType(((TypeInsnNode) insn).desc));
            default:
                throw new AssertionError();
        }
    }

    public BasicValue copyOperation(AbstractInsnNode insn, BasicValue value) throws AnalyzerException {
        return value;
    }

    public BasicValue unaryOperation(AbstractInsnNode insn, BasicValue value) throws AnalyzerException {
        switch (insn.getOpcode()) {
            case 116:
            case Opcodes.IINC /* 132 */:
            case Opcodes.L2I /* 136 */:
            case Opcodes.F2I /* 139 */:
            case Opcodes.D2I /* 142 */:
            case Opcodes.I2B /* 145 */:
            case Opcodes.I2C /* 146 */:
            case Opcodes.I2S /* 147 */:
                return BasicValue.INT_VALUE;
            case 117:
            case Opcodes.I2L /* 133 */:
            case Opcodes.F2L /* 140 */:
            case Opcodes.D2L /* 143 */:
                return BasicValue.LONG_VALUE;
            case 118:
            case Opcodes.I2F /* 134 */:
            case Opcodes.L2F /* 137 */:
            case Opcodes.D2F /* 144 */:
                return BasicValue.FLOAT_VALUE;
            case 119:
            case Opcodes.I2D /* 135 */:
            case Opcodes.L2D /* 138 */:
            case Opcodes.F2D /* 141 */:
                return BasicValue.DOUBLE_VALUE;
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
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case Opcodes.TABLESWITCH /* 170 */:
            case Opcodes.LOOKUPSWITCH /* 171 */:
            case Opcodes.IRETURN /* 172 */:
            case Opcodes.LRETURN /* 173 */:
            case Opcodes.FRETURN /* 174 */:
            case 175:
            case Opcodes.ARETURN /* 176 */:
            case Opcodes.PUTSTATIC /* 179 */:
                return null;
            case 180:
                return newValue(Type.getType(((FieldInsnNode) insn).desc));
            case Opcodes.NEWARRAY /* 188 */:
                switch (((IntInsnNode) insn).operand) {
                    case 4:
                        return newValue(Type.getType("[Z"));
                    case 5:
                        return newValue(Type.getType("[C"));
                    case 6:
                        return newValue(Type.getType("[F"));
                    case 7:
                        return newValue(Type.getType("[D"));
                    case 8:
                        return newValue(Type.getType("[B"));
                    case 9:
                        return newValue(Type.getType("[S"));
                    case 10:
                        return newValue(Type.getType("[I"));
                    case 11:
                        return newValue(Type.getType("[J"));
                    default:
                        throw new AnalyzerException(insn, "Invalid array type");
                }
            case Opcodes.ANEWARRAY /* 189 */:
                return newValue(Type.getType("[" + Type.getObjectType(((TypeInsnNode) insn).desc)));
            case Opcodes.ARRAYLENGTH /* 190 */:
                return BasicValue.INT_VALUE;
            case Opcodes.ATHROW /* 191 */:
                return null;
            case Opcodes.CHECKCAST /* 192 */:
                return newValue(Type.getObjectType(((TypeInsnNode) insn).desc));
            case Opcodes.INSTANCEOF /* 193 */:
                return BasicValue.INT_VALUE;
            case Opcodes.MONITORENTER /* 194 */:
            case Opcodes.MONITOREXIT /* 195 */:
            case Opcodes.IFNULL /* 198 */:
            case Opcodes.IFNONNULL /* 199 */:
                return null;
        }
    }

    public BasicValue binaryOperation(AbstractInsnNode insn, BasicValue value1, BasicValue value2) throws AnalyzerException {
        switch (insn.getOpcode()) {
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
                return BasicValue.INT_VALUE;
            case 47:
            case 97:
            case 101:
            case 105:
            case 109:
            case 113:
            case 121:
            case 123:
            case Opcodes.LUSHR /* 125 */:
            case Opcodes.LAND /* 127 */:
            case Opcodes.LOR /* 129 */:
            case Opcodes.LXOR /* 131 */:
                return BasicValue.LONG_VALUE;
            case 48:
            case 98:
            case 102:
            case 106:
            case 110:
            case 114:
                return BasicValue.FLOAT_VALUE;
            case 49:
            case 99:
            case 103:
            case 107:
            case 111:
            case 115:
                return BasicValue.DOUBLE_VALUE;
            case 50:
                return BasicValue.REFERENCE_VALUE;
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
            case Opcodes.LCMP /* 148 */:
            case Opcodes.FCMPL /* 149 */:
            case 150:
            case Opcodes.DCMPL /* 151 */:
            case Opcodes.DCMPG /* 152 */:
                return BasicValue.INT_VALUE;
            case Opcodes.IF_ICMPEQ /* 159 */:
            case Opcodes.IF_ICMPNE /* 160 */:
            case Opcodes.IF_ICMPLT /* 161 */:
            case Opcodes.IF_ICMPGE /* 162 */:
            case Opcodes.IF_ICMPGT /* 163 */:
            case Opcodes.IF_ICMPLE /* 164 */:
            case Opcodes.IF_ACMPEQ /* 165 */:
            case Opcodes.IF_ACMPNE /* 166 */:
            case Opcodes.PUTFIELD /* 181 */:
                return null;
        }
    }

    public BasicValue ternaryOperation(AbstractInsnNode insn, BasicValue value1, BasicValue value2, BasicValue value3) throws AnalyzerException {
        return null;
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public BasicValue naryOperation(AbstractInsnNode insn, List<? extends BasicValue> values) throws AnalyzerException {
        int opcode = insn.getOpcode();
        if (opcode == 197) {
            return newValue(Type.getType(((MultiANewArrayInsnNode) insn).desc));
        }
        if (opcode == 186) {
            return newValue(Type.getReturnType(((InvokeDynamicInsnNode) insn).desc));
        }
        return newValue(Type.getReturnType(((MethodInsnNode) insn).desc));
    }

    public void returnOperation(AbstractInsnNode insn, BasicValue value, BasicValue expected) throws AnalyzerException {
    }

    public BasicValue merge(BasicValue value1, BasicValue value2) {
        if (!value1.equals(value2)) {
            return BasicValue.UNINITIALIZED_VALUE;
        }
        return value1;
    }
}
