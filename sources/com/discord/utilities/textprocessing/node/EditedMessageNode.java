package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import b.a.t.b.a.TextNode;
import com.discord.R;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.utilities.color.ColorCompat;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EditedMessageNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EditedMessageNode<RC> extends StyleNode<RC, CharacterStyle> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: EditedMessageNode.kt */
    public static final class Companion {
        private Companion() {
        }

        private final ForegroundColorSpan getForegroundColorSpan(Context context) {
            return new ForegroundColorSpan(ColorCompat.getThemedColor(context, R.attr.colorTextMuted));
        }

        private final RelativeSizeSpan getRelativeSizeSpan(float relativeSize) {
            return new RelativeSizeSpan(relativeSize);
        }

        public static /* synthetic */ RelativeSizeSpan getRelativeSizeSpan$default(Companion companion, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = 0.75f;
            }
            return companion.getRelativeSizeSpan(f);
        }

        public final String getEditedString(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            String string = context.getString(R.string.message_edited);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.string.message_edited)");
            return " (" + string + ')';
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public EditedMessageNode(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Companion companion = INSTANCE;
        super(Collections2.listOf(Companion.getRelativeSizeSpan$default(companion, 0.0f, 1, null), companion.getForegroundColorSpan(context)));
        addChild(new TextNode(companion.getEditedString(context)));
    }
}
