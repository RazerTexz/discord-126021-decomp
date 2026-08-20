package org.objectweb.asm.tree;

import java.util.Map;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/MultiANewArrayInsnNode.SCL.lombok */
public class MultiANewArrayInsnNode extends AbstractInsnNode {
    public String desc;
    public int dims;

    public MultiANewArrayInsnNode(String descriptor, int numDimensions) {
        super(Opcodes.MULTIANEWARRAY);
        this.desc = descriptor;
        this.dims = numDimensions;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public int getType() {
        return 13;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitMultiANewArrayInsn(this.desc, this.dims);
        acceptAnnotations(methodVisitor);
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> clonedLabels) {
        return new MultiANewArrayInsnNode(this.desc, this.dims).cloneAnnotations(this);
    }
}
