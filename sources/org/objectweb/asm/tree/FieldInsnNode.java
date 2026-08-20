package org.objectweb.asm.tree;

import java.util.Map;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/FieldInsnNode.SCL.lombok */
public class FieldInsnNode extends AbstractInsnNode {
    public String owner;
    public String name;
    public String desc;

    public FieldInsnNode(int opcode, String owner, String name, String descriptor) {
        super(opcode);
        this.owner = owner;
        this.name = name;
        this.desc = descriptor;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public int getType() {
        return 4;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitFieldInsn(this.opcode, this.owner, this.name, this.desc);
        acceptAnnotations(methodVisitor);
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> clonedLabels) {
        return new FieldInsnNode(this.opcode, this.owner, this.name, this.desc).cloneAnnotations(this);
    }
}
