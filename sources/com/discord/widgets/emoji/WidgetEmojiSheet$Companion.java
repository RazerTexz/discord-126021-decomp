package com.discord.widgets.emoji;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetEmojiSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiSheet$Companion {
    private WidgetEmojiSheet$Companion() {
    }

    private final String getNoticeName(EmojiNode$EmojiIdAndType emojiIdAndType) {
        String str = "Emoji Sheet: " + emojiIdAndType.toString();
        m.checkNotNullExpressionValue(str, "StringBuilder(\"Emoji She…)\n            .toString()");
        return str;
    }

    public final void enqueueNotice(EmojiNode$EmojiIdAndType emojiIdAndType) {
        m.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
        String noticeName = getNoticeName(emojiIdAndType);
        StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice(noticeName, null, 0L, 0, false, null, 0L, false, 0L, new WidgetEmojiSheet$Companion$enqueueNotice$showEmojiSheetNotice$1(emojiIdAndType, noticeName), Opcodes.INVOKEVIRTUAL, null));
    }

    public final void show(FragmentManager fragmentManager, EmojiNode$EmojiIdAndType emojiIdAndType) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
        WidgetEmojiSheet widgetEmojiSheet = new WidgetEmojiSheet();
        Bundle bundle = new Bundle();
        bundle.putSerializable("EXTRA_EMOJI_ID_AND_TYPE", emojiIdAndType);
        widgetEmojiSheet.setArguments(bundle);
        widgetEmojiSheet.show(fragmentManager, WidgetEmojiSheet.class.getName());
    }

    public /* synthetic */ WidgetEmojiSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
