package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EditedMessageNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EditedMessageNode$Companion {
    private EditedMessageNode$Companion() {
    }

    public static final /* synthetic */ ForegroundColorSpan access$getForegroundColorSpan(EditedMessageNode$Companion editedMessageNode$Companion, Context context) {
        return editedMessageNode$Companion.getForegroundColorSpan(context);
    }

    private final ForegroundColorSpan getForegroundColorSpan(Context context) {
        return new ForegroundColorSpan(ColorCompat.getThemedColor(context, 2130969056));
    }

    private final RelativeSizeSpan getRelativeSizeSpan(float relativeSize) {
        return new RelativeSizeSpan(relativeSize);
    }

    public static /* synthetic */ RelativeSizeSpan getRelativeSizeSpan$default(EditedMessageNode$Companion editedMessageNode$Companion, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.75f;
        }
        return editedMessageNode$Companion.getRelativeSizeSpan(f);
    }

    public final String getEditedString(Context context) {
        m.checkNotNullParameter(context, "context");
        String string = context.getString(2131892961);
        m.checkNotNullExpressionValue(string, "context.getString(R.string.message_edited)");
        return " (" + string + ')';
    }

    public /* synthetic */ EditedMessageNode$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
