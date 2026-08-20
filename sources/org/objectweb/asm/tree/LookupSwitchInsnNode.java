package org.objectweb.asm.tree;

import java.util.List;
import java.util.Map;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/LookupSwitchInsnNode.SCL.lombok */
public class LookupSwitchInsnNode extends AbstractInsnNode {
    public LabelNode dflt;
    public List<Integer> keys;
    public List<LabelNode> labels;

    public LookupSwitchInsnNode(LabelNode dflt, int[] keys, LabelNode[] labels) {
        super(Opcodes.LOOKUPSWITCH);
        this.dflt = dflt;
        this.keys = Util.asArrayList(keys);
        this.labels = Util.asArrayList(labels);
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public int getType() {
        return 12;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor methodVisitor) {
        int[] keysArray = new int[this.keys.size()];
        int n = keysArray.length;
        for (int i = 0; i < n; i++) {
            keysArray[i] = this.keys.get(i).intValue();
        }
        Label[] labelsArray = new Label[this.labels.size()];
        int n2 = labelsArray.length;
        for (int i2 = 0; i2 < n2; i2++) {
            labelsArray[i2] = this.labels.get(i2).getLabel();
        }
        methodVisitor.visitLookupSwitchInsn(this.dflt.getLabel(), keysArray, labelsArray);
        acceptAnnotations(methodVisitor);
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> clonedLabels) {
        LookupSwitchInsnNode clone = new LookupSwitchInsnNode(clone(this.dflt, clonedLabels), null, clone(this.labels, clonedLabels));
        clone.keys.addAll(this.keys);
        return clone.cloneAnnotations(this);
    }
}
