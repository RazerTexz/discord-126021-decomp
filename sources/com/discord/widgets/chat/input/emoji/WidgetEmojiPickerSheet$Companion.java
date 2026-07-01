package com.discord.widgets.chat.input.emoji;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEmojiPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPickerSheet$Companion {
    private WidgetEmojiPickerSheet$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void show$default(WidgetEmojiPickerSheet$Companion widgetEmojiPickerSheet$Companion, FragmentManager fragmentManager, EmojiPickerListener emojiPickerListener, EmojiPickerContextType emojiPickerContextType, Function0 function0, int i, Object obj) {
        if ((i & 8) != 0) {
            function0 = null;
        }
        widgetEmojiPickerSheet$Companion.show(fragmentManager, emojiPickerListener, emojiPickerContextType, function0);
    }

    public final void show(FragmentManager fragmentManager, EmojiPickerListener emojiPickerListener, EmojiPickerContextType emojiPickerContextType, Function0<Unit> onCancel) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
        WidgetEmojiPickerSheet widgetEmojiPickerSheet = new WidgetEmojiPickerSheet();
        Bundle bundle = new Bundle();
        bundle.putSerializable(EmojiPickerNavigator.ARG_EMOJI_PICKER_CONTEXT_TYPE, emojiPickerContextType);
        widgetEmojiPickerSheet.setArguments(bundle);
        widgetEmojiPickerSheet.setEmojiPickerListener(emojiPickerListener);
        widgetEmojiPickerSheet.setOnCancel(onCancel);
        widgetEmojiPickerSheet.show(fragmentManager, WidgetEmojiPickerSheet.class.getSimpleName());
    }

    public /* synthetic */ WidgetEmojiPickerSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
