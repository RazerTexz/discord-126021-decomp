package com.discord.widgets.chat.input.emoji;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.R;
import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEmojiPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPickerSheet extends WidgetExpressionPickerSheet implements EmojiPickerListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private View container;
    private WidgetEmojiPicker emojiPickerFragment;
    private EmojiPickerListener emojiPickerListenerDelegate;

    /* JADX INFO: compiled from: WidgetEmojiPickerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, EmojiPickerListener emojiPickerListener, EmojiPickerContextType emojiPickerContextType, Function0 function0, int i, Object obj) {
            if ((i & 8) != 0) {
                function0 = null;
            }
            companion.show(fragmentManager, emojiPickerListener, emojiPickerContextType, function0);
        }

        public final void show(FragmentManager fragmentManager, EmojiPickerListener emojiPickerListener, EmojiPickerContextType emojiPickerContextType, Function0<Unit> onCancel) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
            WidgetEmojiPickerSheet widgetEmojiPickerSheet = new WidgetEmojiPickerSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable(EmojiPickerNavigator.ARG_EMOJI_PICKER_CONTEXT_TYPE, emojiPickerContextType);
            widgetEmojiPickerSheet.setArguments(bundle);
            widgetEmojiPickerSheet.setEmojiPickerListener(emojiPickerListener);
            widgetEmojiPickerSheet.setOnCancel(onCancel);
            widgetEmojiPickerSheet.show(fragmentManager, WidgetEmojiPickerSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ View access$getContainer$p(WidgetEmojiPickerSheet widgetEmojiPickerSheet) {
        View view = widgetEmojiPickerSheet.container;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("container");
        }
        return view;
    }

    private final void cancelDialog() {
        WidgetEmojiPicker widgetEmojiPicker = this.emojiPickerFragment;
        if (widgetEmojiPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        widgetEmojiPicker.clearSearchInput();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_emoji_picker_sheet;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        cancelDialog();
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
    public void onEmojiPicked(Emoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        EmojiPickerListener emojiPickerListener = this.emojiPickerListenerDelegate;
        if (emojiPickerListener != null) {
            emojiPickerListener.onEmojiPicked(emoji);
        }
        cancelDialog();
        dismiss();
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.container = view;
        WidgetEmojiPicker widgetEmojiPicker = new WidgetEmojiPicker();
        this.emojiPickerFragment = widgetEmojiPicker;
        if (widgetEmojiPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiPickerFragment");
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
            Intrinsics3.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        widgetEmojiPicker2.setListener(this);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        WidgetEmojiPicker widgetEmojiPicker3 = this.emojiPickerFragment;
        if (widgetEmojiPicker3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        WidgetEmojiPicker widgetEmojiPicker4 = this.emojiPickerFragment;
        if (widgetEmojiPicker4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojiPickerFragment");
        }
        fragmentTransactionBeginTransaction.replace(R.id.emoji_sheet_emoji_picker_content, widgetEmojiPicker3, widgetEmojiPicker4.getClass().getSimpleName()).runOnCommit(new Runnable() { // from class: com.discord.widgets.chat.input.emoji.WidgetEmojiPickerSheet.onViewCreated.2
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup.LayoutParams layoutParams = WidgetEmojiPickerSheet.access$getContainer$p(WidgetEmojiPickerSheet.this).getLayoutParams();
                if (layoutParams != null) {
                    Resources resources = WidgetEmojiPickerSheet.this.getResources();
                    Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                    layoutParams.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
                }
            }
        }).commit();
    }

    public final void setEmojiPickerListener(EmojiPickerListener emojiPickerListener) {
        this.emojiPickerListenerDelegate = emojiPickerListener;
    }
}
