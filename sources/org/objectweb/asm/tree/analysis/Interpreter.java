package org.objectweb.asm.tree.analysis;

import java.util.List;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.TryCatchBlockNode;
import org.objectweb.asm.tree.analysis.Value;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/analysis/Interpreter.SCL.lombok */
public abstract class Interpreter<V extends Value> {
    protected final int api;

    public abstract V newValue(Type type);

    public abstract V newOperation(AbstractInsnNode abstractInsnNode) throws AnalyzerException;

    public abstract V copyOperation(AbstractInsnNode abstractInsnNode, V v) throws AnalyzerException;

    public abstract V unaryOperation(AbstractInsnNode abstractInsnNode, V v) throws AnalyzerException;

    public abstract V binaryOperation(AbstractInsnNode abstractInsnNode, V v, V v2) throws AnalyzerException;

    public abstract V ternaryOperation(AbstractInsnNode abstractInsnNode, V v, V v2, V v3) throws AnalyzerException;

    public abstract V naryOperation(AbstractInsnNode abstractInsnNode, List<? extends V> list) throws AnalyzerException;

    public abstract void returnOperation(AbstractInsnNode abstractInsnNode, V v, V v2) throws AnalyzerException;

    public abstract V merge(V v, V v2);

    protected Interpreter(int api) {
        this.api = api;
    }

    public V newParameterValue(boolean z2, int i, Type type) {
        return (V) newValue(type);
    }

    public V newReturnTypeValue(Type type) {
        return (V) newValue(type);
    }

    public V newEmptyValue(int i) {
        return (V) newValue(null);
    }

    public V newExceptionValue(TryCatchBlockNode tryCatchBlockNode, Frame<V> frame, Type type) {
        return (V) newValue(type);
    }
}
