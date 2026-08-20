package org.objectweb.asm.tree;

import java.util.Map;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/InsnNode.SCL.lombok */
public class InsnNode extends AbstractInsnNode {
    public InsnNode(int opcode) {
        super(opcode);
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public int getType() {
        return 0;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitInsn(this.opcode);
        acceptAnnotations(methodVisitor);
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> clonedLabels) {
        return new InsnNode(this.opcode).cloneAnnotations(this);
    }
}
