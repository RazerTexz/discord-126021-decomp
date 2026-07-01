package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.style.CharacterStyle;
import b.a.t.b.a.a;
import com.discord.simpleast.core.node.StyleNode;
import d0.t.n;
import d0.z.d.m;

/* JADX INFO: compiled from: EditedMessageNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EditedMessageNode<RC> extends StyleNode<RC, CharacterStyle> {
    public static final EditedMessageNode$Companion Companion = new EditedMessageNode$Companion(null);

    /* JADX WARN: Illegal instructions before constructor call */
    public EditedMessageNode(Context context) {
        m.checkNotNullParameter(context, "context");
        EditedMessageNode$Companion editedMessageNode$Companion = Companion;
        super(n.listOf(EditedMessageNode$Companion.getRelativeSizeSpan$default(editedMessageNode$Companion, 0.0f, 1, null), EditedMessageNode$Companion.access$getForegroundColorSpan(editedMessageNode$Companion, context)));
        addChild(new a(editedMessageNode$Companion.getEditedString(context)));
    }
}
