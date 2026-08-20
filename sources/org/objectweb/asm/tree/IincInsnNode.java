package org.objectweb.asm.tree;

import java.util.Map;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/IincInsnNode.SCL.lombok */
public class IincInsnNode extends AbstractInsnNode {
    public int var;
    public int incr;

    public IincInsnNode(int var, int incr) {
        super(Opcodes.IINC);
        this.var = var;
        this.incr = incr;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public int getType() {
        return 10;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitIincInsn(this.var, this.incr);
        acceptAnnotations(methodVisitor);
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> clonedLabels) {
        return new IincInsnNode(this.var, this.incr).cloneAnnotations(this);
    }
}
