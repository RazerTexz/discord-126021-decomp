package com.discord.widgets.chat.input;

import android.content.ContentResolver;
import android.content.Context;
import android.widget.TextView;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import com.discord.R$id;
import com.discord.app.AppFragment;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.chat.input.expression.WidgetExpressionTray;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments {
    private final FlexInputFragment flexInputFragment;

    public WidgetChatInputAttachments(FlexInputFragment flexInputFragment) {
        m.checkNotNullParameter(flexInputFragment, "flexInputFragment");
        this.flexInputFragment = flexInputFragment;
    }

    public static final /* synthetic */ Fragment access$createAndConfigureExpressionFragment(WidgetChatInputAttachments widgetChatInputAttachments, FragmentManager fragmentManager, TextView textView) {
        return widgetChatInputAttachments.createAndConfigureExpressionFragment(fragmentManager, textView);
    }

    public static final /* synthetic */ AttachmentPreviewAdapter access$createPreviewAdapter(WidgetChatInputAttachments widgetChatInputAttachments, Context context) {
        return widgetChatInputAttachments.createPreviewAdapter(context);
    }

    public static final /* synthetic */ FlexInputFragment access$getFlexInputFragment$p(WidgetChatInputAttachments widgetChatInputAttachments) {
        return widgetChatInputAttachments.flexInputFragment;
    }

    public static final /* synthetic */ void access$setAttachmentFromPicker(WidgetChatInputAttachments widgetChatInputAttachments, Context context, InputContentInfoCompat inputContentInfoCompat) {
        widgetChatInputAttachments.setAttachmentFromPicker(context, inputContentInfoCompat);
    }

    private final Fragment createAndConfigureExpressionFragment(FragmentManager fragmentManager, TextView chatInput) {
        WidgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1 widgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1 = new WidgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1(this);
        WidgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1 widgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1 = new WidgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1(this);
        WidgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1 widgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1 = new WidgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1(chatInput);
        Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(R$id.expression_tray_container);
        if (!(fragmentFindFragmentById instanceof WidgetExpressionTray)) {
            fragmentFindFragmentById = null;
        }
        WidgetExpressionTray widgetExpressionTray = (WidgetExpressionTray) fragmentFindFragmentById;
        if (widgetExpressionTray == null) {
            widgetExpressionTray = new WidgetExpressionTray();
        }
        widgetExpressionTray.setEmojiPickerListener(widgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1);
        widgetExpressionTray.setStickerPickerListener(widgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1);
        widgetExpressionTray.setOnBackspacePressedListener(widgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1);
        widgetExpressionTray.setOnEmojiSearchOpenedListener(new WidgetChatInputAttachments$createAndConfigureExpressionFragment$1(this));
        return widgetExpressionTray;
    }

    private final <T extends Attachment<? extends Object>> AttachmentPreviewAdapter<T> createPreviewAdapter(Context context) {
        WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1 widgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1 = new WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1(this);
        Experiment userExperiment = StoreStream.Companion.getExperiments().getUserExperiment("2021-10_android_attachment_bottom_sheet", true);
        return new AttachmentPreviewAdapter<>(userExperiment != null && userExperiment.getBucket() == 1, widgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1, new WidgetChatInputAttachments$createPreviewAdapter$1(this, context));
    }

    private final void setAttachmentFromPicker(Context context, InputContentInfoCompat inputContentInfoCompat) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {
            this.flexInputFragment.f(new SourcedAttachment(Attachment.Companion.c(inputContentInfoCompat, contentResolver, true, b.h(context, 2131886872, new Object[0], null, 4).toString()), AnalyticsTracker.ATTACHMENT_SOURCE_KEYBOARD));
        }
    }

    public final void addExternalAttachment(Attachment<? extends Object> attachment) {
        m.checkNotNullParameter(attachment, "attachment");
        this.flexInputFragment.i(new WidgetChatInputAttachments$addExternalAttachment$1(this, attachment));
    }

    public final void configureFlexInputContentPages(boolean canCreateThread) {
        this.flexInputFragment.i(new WidgetChatInputAttachments$configureFlexInputContentPages$1(this, canCreateThread));
    }

    public final void configureFlexInputFragment(AppFragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        this.flexInputFragment.i(new WidgetChatInputAttachments$configureFlexInputFragment$1(this, fragment));
        fragment.setOnBackPressed(new WidgetChatInputAttachments$configureFlexInputFragment$2(this), 1);
    }

    public final void setInputListener(FlexInputListener inputListener) {
        m.checkNotNullParameter(inputListener, "inputListener");
        FlexInputFragment flexInputFragment = this.flexInputFragment;
        Objects.requireNonNull(flexInputFragment);
        m.checkNotNullParameter(inputListener, "inputListener");
        flexInputFragment.inputListener = inputListener;
    }

    public final void setViewModel(FlexInputViewModel viewModel) {
        this.flexInputFragment.viewModel = viewModel;
    }
}
