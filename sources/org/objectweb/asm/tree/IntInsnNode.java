package org.objectweb.asm.tree;

import java.util.Map;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/IntInsnNode.SCL.lombok */
public class IntInsnNode extends AbstractInsnNode {
    public int operand;

    public IntInsnNode(int opcode, int operand) {
        super(opcode);
        this.operand = operand;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public int getType() {
        return 1;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitIntInsn(this.opcode, this.operand);
        acceptAnnotations(methodVisitor);
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> clonedLabels) {
        return new IntInsnNode(this.opcode, this.operand).cloneAnnotations(this);
    }
}
