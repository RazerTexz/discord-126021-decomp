package com.discord.widgets.chat.input.emoji;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet;
import d0.z.d.m;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetEmojiPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPickerSheet extends WidgetExpressionPickerSheet implements EmojiPickerListener {
    public static final WidgetEmojiPickerSheet$Companion Companion = new WidgetEmojiPickerSheet$Companion(null);
    private View container;
    private WidgetEmojiPicker emojiPickerFragment;
    private EmojiPickerListener emojiPickerListenerDelegate;

    public static final /* synthetic */ View access$getContainer$p(WidgetEmojiPickerSheet widgetEmojiPickerSheet) {
        View view = widgetEmojiPickerSheet.container;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("container");
        }
        return view;
    }

    public static final /* synthetic */ void access$setContainer$p(WidgetEmojiPickerSheet widgetEmojiPickerSheet, View view) {
        widgetEmojiPickerSheet.container = view;
    }

    private final void cancelDialog() {
        WidgetEmojiPicker widgetEmojiPicker = this.emojiPickerFragment;
        if (widgetEmojiPicker == null) {
            m.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        widgetEmojiPicker.clearSearchInput();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_emoji_picker_sheet;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnCancelListener
    public void onCancel(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        cancelDialog();
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
    public void onEmojiPicked(Emoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        EmojiPickerListener emojiPickerListener = this.emojiPickerListenerDelegate;
        if (emojiPickerListener != null) {
            emojiPickerListener.onEmojiPicked(emoji);
        }
        cancelDialog();
        dismiss();
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.container = view;
        WidgetEmojiPicker widgetEmojiPicker = new WidgetEmojiPicker();
        this.emojiPickerFragment = widgetEmojiPicker;
        if (widgetEmojiPicker == null) {
            m.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("MODE", EmojiPickerMode.BOTTOM_SHEET);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(EmojiPickerNavigator.ARG_EMOJI_PICKER_CONTEXT_TYPE) : null;
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.chat.input.emoji.EmojiPickerContextType");
        bundle.putSerializable(EmojiPickerNavigator.ARG_EMOJI_PICKER_CONTEXT_TYPE, (EmojiPickerContextType) serializable);
        widgetEmojiPicker.setArguments(bundle);
        WidgetEmojiPicker widgetEmojiPicker2 = this.emojiPickerFragment;
        if (widgetEmojiPicker2 == null) {
            m.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        widgetEmojiPicker2.setListener(this);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        WidgetEmojiPicker widgetEmojiPicker3 = this.emojiPickerFragment;
        if (widgetEmojiPicker3 == null) {
            m.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        WidgetEmojiPicker widgetEmojiPicker4 = this.emojiPickerFragment;
        if (widgetEmojiPicker4 == null) {
            m.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        fragmentTransactionBeginTransaction.replace(R$id.emoji_sheet_emoji_picker_content, widgetEmojiPicker3, widgetEmojiPicker4.getClass().getSimpleName()).runOnCommit(new WidgetEmojiPickerSheet$onViewCreated$2(this)).commit();
    }

    public final void setEmojiPickerListener(EmojiPickerListener emojiPickerListener) {
        this.emojiPickerListenerDelegate = emojiPickerListener;
    }
}
