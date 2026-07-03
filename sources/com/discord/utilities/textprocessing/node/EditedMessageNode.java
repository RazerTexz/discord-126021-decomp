package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import com.discord.C5419R;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.utilities.color.ColorCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p050t.p052b.p053a.C1298a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

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
            return new ForegroundColorSpan(ColorCompat.getThemedColor(context, C5419R.attr.colorTextMuted));
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
            C12238m.checkNotNullParameter(context, "context");
            String string = context.getString(C5419R.string.message_edited);
            C12238m.checkNotNullExpressionValue(string, "context.getString(R.string.message_edited)");
            return " (" + string + ')';
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public EditedMessageNode(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        Companion companion = INSTANCE;
        super(C12147n.listOf(Companion.getRelativeSizeSpan$default(companion, 0.0f, 1, null), companion.getForegroundColorSpan(context)));
        addChild(new C1298a(companion.getEditedString(context)));
    }
}
