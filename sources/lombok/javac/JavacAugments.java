package lombok.javac;

import com.sun.tools.javac.tree.JCTree;
import lombok.core.FieldAugment;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/JavacAugments.SCL.lombok */
public final class JavacAugments {
    public static final FieldAugment<JCTree, Boolean> JCTree_handled = FieldAugment.augment(JCTree.class, Boolean.TYPE, "lombok$handled");
    public static final FieldAugment<JCTree, JCTree> JCTree_generatedNode = FieldAugment.circularSafeAugment(JCTree.class, JCTree.class, "lombok$generatedNode");

    private JavacAugments() {
    }
}
