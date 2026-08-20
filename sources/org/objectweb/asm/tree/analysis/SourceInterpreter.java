package org.objectweb.asm.tree.analysis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/analysis/SourceInterpreter.SCL.lombok */
public class SourceInterpreter extends Interpreter<SourceValue> implements Opcodes {
    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value merge(Value value, Value value2) {
        return merge((SourceValue) value, (SourceValue) value2);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ void returnOperation(AbstractInsnNode abstractInsnNode, Value value, Value value2) throws AnalyzerException {
        returnOperation(abstractInsnNode, (SourceValue) value, (SourceValue) value2);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value naryOperation(AbstractInsnNode abstractInsnNode, List list) throws AnalyzerException {
        return naryOperation(abstractInsnNode, (List<? extends SourceValue>) list);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value ternaryOperation(AbstractInsnNode abstractInsnNode, Value value, Value value2, Value value3) throws AnalyzerException {
        return ternaryOperation(abstractInsnNode, (SourceValue) value, (SourceValue) value2, (SourceValue) value3);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value binaryOperation(AbstractInsnNode abstractInsnNode, Value value, Value value2) throws AnalyzerException {
        return binaryOperation(abstractInsnNode, (SourceValue) value, (SourceValue) value2);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value unaryOperation(AbstractInsnNode abstractInsnNode, Value value) throws AnalyzerException {
        return unaryOperation(abstractInsnNode, (SourceValue) value);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value copyOperation(AbstractInsnNode abstractInsnNode, Value value) throws AnalyzerException {
        return copyOperation(abstractInsnNode, (SourceValue) value);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value newOperation(AbstractInsnNode abstractInsnNode) throws AnalyzerException {
        return newOperation(abstractInsnNode);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value newValue(Type type) {
        return newValue(type);
    }

    public SourceInterpreter() {
        super(Opcodes.ASM9);
        if (getClass() != SourceInterpreter.class) {
            throw new IllegalStateException();
        }
    }

    protected SourceInterpreter(int api) {
        super(api);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public SourceValue newValue(Type type) {
        if (type == Type.VOID_TYPE) {
            return null;
        }
        return new SourceValue(type == null ? 1 : type.getSize());
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public SourceValue newOperation(AbstractInsnNode insn) {
        int size;
        switch (insn.getOpcode()) {
            case 9:
            case 10:
            case 14:
            case 15:
                size = 2;
                break;
            case 18:
                Object value = ((LdcInsnNode) insn).cst;
                size = ((value instanceof Long) || (value instanceof Double)) ? 2 : 1;
                break;
            case Opcodes.GETSTATIC /* 178 */:
                size = Type.getType(((FieldInsnNode) insn).desc).getSize();
                break;
            default:
                size = 1;
                break;
        }
        return new SourceValue(size, insn);
    }

    public SourceValue copyOperation(AbstractInsnNode insn, SourceValue value) {
        return new SourceValue(value.getSize(), insn);
    }

    public SourceValue unaryOperation(AbstractInsnNode insn, SourceValue value) {
        int size;
        switch (insn.getOpcode()) {
            case 117:
            case 119:
            case Opcodes.I2L /* 133 */:
            case Opcodes.I2D /* 135 */:
            case Opcodes.L2D /* 138 */:
            case Opcodes.F2L /* 140 */:
            case Opcodes.F2D /* 141 */:
            case Opcodes.D2L /* 143 */:
                size = 2;
                break;
            case 180:
                size = Type.getType(((FieldInsnNode) insn).desc).getSize();
                break;
            default:
                size = 1;
                break;
        }
        return new SourceValue(size, insn);
    }

    public SourceValue binaryOperation(AbstractInsnNode insn, SourceValue value1, SourceValue value2) {
        int size;
        switch (insn.getOpcode()) {
            case 47:
            case 49:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case 107:
            case 109:
            case 111:
            case 113:
            case 115:
            case 121:
            case 123:
            case Opcodes.LUSHR /* 125 */:
            case Opcodes.LAND /* 127 */:
            case Opcodes.LOR /* 129 */:
            case Opcodes.LXOR /* 131 */:
                size = 2;
                break;
            default:
                size = 1;
                break;
        }
        return new SourceValue(size, insn);
    }

    public SourceValue ternaryOperation(AbstractInsnNode insn, SourceValue value1, SourceValue value2, SourceValue value3) {
        return new SourceValue(1, insn);
    }

    @Override // org.objectweb.asm.tree.analysis.Interpreter
    public SourceValue naryOperation(AbstractInsnNode insn, List<? extends SourceValue> values) {
        int size;
        int opcode = insn.getOpcode();
        if (opcode == 197) {
            size = 1;
        } else if (opcode == 186) {
            size = Type.getReturnType(((InvokeDynamicInsnNode) insn).desc).getSize();
        } else {
            size = Type.getReturnType(((MethodInsnNode) insn).desc).getSize();
        }
        return new SourceValue(size, insn);
    }

    public void returnOperation(AbstractInsnNode insn, SourceValue value, SourceValue expected) {
    }

    public SourceValue merge(SourceValue value1, SourceValue value2) {
        if ((value1.insns instanceof SmallSet) && (value2.insns instanceof SmallSet)) {
            Set<AbstractInsnNode> setUnion = ((SmallSet) value1.insns).union((SmallSet) value2.insns);
            if (setUnion == value1.insns && value1.size == value2.size) {
                return value1;
            }
            return new SourceValue(Math.min(value1.size, value2.size), setUnion);
        }
        if (value1.size != value2.size || !containsAll(value1.insns, value2.insns)) {
            HashSet<AbstractInsnNode> setUnion2 = new HashSet<>();
            setUnion2.addAll(value1.insns);
            setUnion2.addAll(value2.insns);
            return new SourceValue(Math.min(value1.size, value2.size), setUnion2);
        }
        return value1;
    }

    private static <E> boolean containsAll(Set<E> self, Set<E> other) {
        if (self.size() < other.size()) {
            return false;
        }
        return self.containsAll(other);
    }
}
