package com.discord.widgets.chat.input.emoji;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: EmojiPickerNavigator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiPickerNavigator {
    public static final String ARG_EMOJI_PICKER_CONTEXT_TYPE = "EMOJI_PICKER_CONTEXT_TYPE";
    public static final String ARG_MODE = "MODE";
    public static final EmojiPickerNavigator INSTANCE = new EmojiPickerNavigator();

    private EmojiPickerNavigator() {
    }

    public static final void launchBottomSheet(FragmentManager fragmentManager, EmojiPickerListener emojiPickerListener, EmojiPickerContextType emojiPickerContextType, Function0<Unit> onCancel) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
        WidgetEmojiPickerSheet.Companion.show(fragmentManager, emojiPickerListener, emojiPickerContextType, onCancel);
    }

    public static /* synthetic */ void launchBottomSheet$default(FragmentManager fragmentManager, EmojiPickerListener emojiPickerListener, EmojiPickerContextType emojiPickerContextType, Function0 function0, int i, Object obj) {
        if ((i & 8) != 0) {
            function0 = null;
        }
        launchBottomSheet(fragmentManager, emojiPickerListener, emojiPickerContextType, function0);
    }
}
