package org.objectweb.asm.commons;

import java.util.AbstractMap;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.LabelNode;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/commons/JSRInlinerAdapter$Instantiation.SCL.lombok */
class JSRInlinerAdapter$Instantiation extends AbstractMap<LabelNode, LabelNode> {
    final JSRInlinerAdapter$Instantiation parent;
    final BitSet subroutineInsns;
    final Map<LabelNode, LabelNode> clonedLabels;
    final LabelNode returnLabel;
    final /* synthetic */ JSRInlinerAdapter this$0;

    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return get(obj);
    }

    JSRInlinerAdapter$Instantiation(JSRInlinerAdapter jSRInlinerAdapter, JSRInlinerAdapter$Instantiation parent, BitSet subroutineInsns) {
        this.this$0 = jSRInlinerAdapter;
        JSRInlinerAdapter$Instantiation jSRInlinerAdapter$Instantiation = parent;
        while (true) {
            JSRInlinerAdapter$Instantiation instantiation = jSRInlinerAdapter$Instantiation;
            if (instantiation != null) {
                if (instantiation.subroutineInsns != subroutineInsns) {
                    jSRInlinerAdapter$Instantiation = instantiation.parent;
                } else {
                    throw new IllegalArgumentException("Recursive invocation of " + subroutineInsns);
                }
            } else {
                this.parent = parent;
                this.subroutineInsns = subroutineInsns;
                this.returnLabel = parent == null ? null : new LabelNode();
                this.clonedLabels = new HashMap();
                LabelNode clonedLabelNode = null;
                for (int insnIndex = 0; insnIndex < jSRInlinerAdapter.instructions.size(); insnIndex++) {
                    AbstractInsnNode insnNode = jSRInlinerAdapter.instructions.get(insnIndex);
                    if (insnNode.getType() == 8) {
                        LabelNode labelNode = (LabelNode) insnNode;
                        clonedLabelNode = clonedLabelNode == null ? new LabelNode() : clonedLabelNode;
                        this.clonedLabels.put(labelNode, clonedLabelNode);
                    } else if (findOwner(insnIndex) == this) {
                        clonedLabelNode = null;
                    }
                }
                return;
            }
        }
    }

    JSRInlinerAdapter$Instantiation findOwner(int insnIndex) {
        if (!this.subroutineInsns.get(insnIndex)) {
            return null;
        }
        if (!this.this$0.sharedSubroutineInsns.get(insnIndex)) {
            return this;
        }
        JSRInlinerAdapter$Instantiation owner = this;
        JSRInlinerAdapter$Instantiation jSRInlinerAdapter$Instantiation = this.parent;
        while (true) {
            JSRInlinerAdapter$Instantiation instantiation = jSRInlinerAdapter$Instantiation;
            if (instantiation != null) {
                if (instantiation.subroutineInsns.get(insnIndex)) {
                    owner = instantiation;
                }
                jSRInlinerAdapter$Instantiation = instantiation.parent;
            } else {
                return owner;
            }
        }
    }

    LabelNode getClonedLabelForJumpInsn(LabelNode labelNode) {
        return findOwner(this.this$0.instructions.indexOf(labelNode)).clonedLabels.get(labelNode);
    }

    LabelNode getClonedLabel(LabelNode labelNode) {
        return this.clonedLabels.get(labelNode);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map$Entry<LabelNode, LabelNode>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public LabelNode get(Object key) {
        return getClonedLabelForJumpInsn((LabelNode) key);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object other) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        throw new UnsupportedOperationException();
    }
}
