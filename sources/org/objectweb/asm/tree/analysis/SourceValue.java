package org.objectweb.asm.tree.analysis;

import java.util.Set;
import org.objectweb.asm.tree.AbstractInsnNode;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/analysis/SourceValue.SCL.lombok */
public class SourceValue implements Value {
    public final int size;
    public final Set<AbstractInsnNode> insns;

    public SourceValue(int size) {
        this(size, new SmallSet());
    }

    public SourceValue(int size, AbstractInsnNode insnNode) {
        this.size = size;
        this.insns = new SmallSet(insnNode);
    }

    public SourceValue(int size, Set<AbstractInsnNode> insnSet) {
        this.size = size;
        this.insns = insnSet;
    }

    @Override // org.objectweb.asm.tree.analysis.Value
    public int getSize() {
        return this.size;
    }

    public boolean equals(Object value) {
        if (!(value instanceof SourceValue)) {
            return false;
        }
        SourceValue sourceValue = (SourceValue) value;
        return this.size == sourceValue.size && this.insns.equals(sourceValue.insns);
    }

    public int hashCode() {
        return this.insns.hashCode();
    }
}
