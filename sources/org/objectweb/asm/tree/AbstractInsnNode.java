package org.objectweb.asm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/AbstractInsnNode.SCL.lombok */
public abstract class AbstractInsnNode {
    public static final int INSN = 0;
    public static final int INT_INSN = 1;
    public static final int VAR_INSN = 2;
    public static final int TYPE_INSN = 3;
    public static final int FIELD_INSN = 4;
    public static final int METHOD_INSN = 5;
    public static final int INVOKE_DYNAMIC_INSN = 6;
    public static final int JUMP_INSN = 7;
    public static final int LABEL = 8;
    public static final int LDC_INSN = 9;
    public static final int IINC_INSN = 10;
    public static final int TABLESWITCH_INSN = 11;
    public static final int LOOKUPSWITCH_INSN = 12;
    public static final int MULTIANEWARRAY_INSN = 13;
    public static final int FRAME = 14;
    public static final int LINE = 15;
    protected int opcode;
    public List<TypeAnnotationNode> visibleTypeAnnotations;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    AbstractInsnNode previousInsn;
    AbstractInsnNode nextInsn;
    int index = -1;

    public abstract int getType();

    public abstract void accept(MethodVisitor methodVisitor);

    public abstract AbstractInsnNode clone(Map<LabelNode, LabelNode> map);

    protected AbstractInsnNode(int opcode) {
        this.opcode = opcode;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public AbstractInsnNode getPrevious() {
        return this.previousInsn;
    }

    public AbstractInsnNode getNext() {
        return this.nextInsn;
    }

    protected final void acceptAnnotations(MethodVisitor methodVisitor) {
        if (this.visibleTypeAnnotations != null) {
            int n = this.visibleTypeAnnotations.size();
            for (int i = 0; i < n; i++) {
                TypeAnnotationNode typeAnnotation = this.visibleTypeAnnotations.get(i);
                typeAnnotation.accept(methodVisitor.visitInsnAnnotation(typeAnnotation.typeRef, typeAnnotation.typePath, typeAnnotation.desc, true));
            }
        }
        if (this.invisibleTypeAnnotations != null) {
            int n2 = this.invisibleTypeAnnotations.size();
            for (int i2 = 0; i2 < n2; i2++) {
                TypeAnnotationNode typeAnnotation2 = this.invisibleTypeAnnotations.get(i2);
                typeAnnotation2.accept(methodVisitor.visitInsnAnnotation(typeAnnotation2.typeRef, typeAnnotation2.typePath, typeAnnotation2.desc, false));
            }
        }
    }

    static LabelNode clone(LabelNode label, Map<LabelNode, LabelNode> clonedLabels) {
        return clonedLabels.get(label);
    }

    static LabelNode[] clone(List<LabelNode> labels, Map<LabelNode, LabelNode> clonedLabels) {
        LabelNode[] clones = new LabelNode[labels.size()];
        int n = clones.length;
        for (int i = 0; i < n; i++) {
            clones[i] = clonedLabels.get(labels.get(i));
        }
        return clones;
    }

    protected final AbstractInsnNode cloneAnnotations(AbstractInsnNode insnNode) {
        if (insnNode.visibleTypeAnnotations != null) {
            this.visibleTypeAnnotations = new ArrayList();
            int n = insnNode.visibleTypeAnnotations.size();
            for (int i = 0; i < n; i++) {
                TypeAnnotationNode sourceAnnotation = insnNode.visibleTypeAnnotations.get(i);
                TypeAnnotationNode cloneAnnotation = new TypeAnnotationNode(sourceAnnotation.typeRef, sourceAnnotation.typePath, sourceAnnotation.desc);
                sourceAnnotation.accept(cloneAnnotation);
                this.visibleTypeAnnotations.add(cloneAnnotation);
            }
        }
        if (insnNode.invisibleTypeAnnotations != null) {
            this.invisibleTypeAnnotations = new ArrayList();
            int n2 = insnNode.invisibleTypeAnnotations.size();
            for (int i2 = 0; i2 < n2; i2++) {
                TypeAnnotationNode sourceAnnotation2 = insnNode.invisibleTypeAnnotations.get(i2);
                TypeAnnotationNode cloneAnnotation2 = new TypeAnnotationNode(sourceAnnotation2.typeRef, sourceAnnotation2.typePath, sourceAnnotation2.desc);
                sourceAnnotation2.accept(cloneAnnotation2);
                this.invisibleTypeAnnotations.add(cloneAnnotation2);
            }
        }
        return this;
    }
}
