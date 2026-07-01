package com.discord.widgets.chat.input;

import android.content.ContentResolver;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.WidgetChatInputPermReqFilesBinding;
import b.a.k.FormatUtils;
import b.b.a.d.AddContentPagerAdapter4;
import b.b.a.f.KeyboardManager;
import com.discord.R;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.attachments.AttachmentUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.widgets.chat.input.WidgetChatInputAttachments;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.expression.WidgetExpressionTray;
import com.discord.widgets.chat.input.sticker.StickerPickerListener;
import com.google.android.material.button.MaterialButton;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.fragment.CameraFragment;
import com.lytefast.flexinput.fragment.FilesFragment;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.fragment.MediaFragment;
import com.lytefast.flexinput.managers.FileManager;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments {
    private final FlexInputFragment flexInputFragment;

    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class DiscordFilesFragment extends FilesFragment {
        @Override // com.lytefast.flexinput.fragment.FilesFragment
        public EmptyListAdapter newPermissionsRequestAdapter(View.OnClickListener onClickListener) {
            Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
            return new PermissionsEmptyListAdapter(R.layout.widget_chat_input_perm_req_files, R.id.action_btn, onClickListener);
        }
    }

    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class DiscordMediaFragment extends MediaFragment {
        @Override // com.lytefast.flexinput.fragment.MediaFragment
        public EmptyListAdapter newPermissionsRequestAdapter(View.OnClickListener onClickListener) {
            Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
            return new PermissionsEmptyListAdapter(R.layout.widget_chat_input_perm_req_files, R.id.action_btn, onClickListener);
        }
    }

    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class PermissionsEmptyListAdapter extends EmptyListAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PermissionsEmptyListAdapter(@LayoutRes int i, @IdRes int i2, View.OnClickListener onClickListener) {
            super(i, i2, onClickListener);
            Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        }

        @Override // com.lytefast.flexinput.adapters.EmptyListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public EmptyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            EmptyListAdapter.ViewHolder viewHolderOnCreateViewHolder = super.onCreateViewHolder(parent, viewType);
            View view = viewHolderOnCreateViewHolder.itemView;
            int i = R.id.action_btn;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.action_btn);
            if (materialButton != null) {
                i = R.id.perm_req_text;
                TextView textView = (TextView) view.findViewById(R.id.perm_req_text);
                if (textView != null) {
                    Intrinsics3.checkNotNullExpressionValue(new WidgetChatInputPermReqFilesBinding((LinearLayout) view, materialButton, textView), "WidgetChatInputPermReqFi…ing.bind(holder.itemView)");
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.permReqText");
                    FormatUtils.m(textView, R.string.system_permission_request_files, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
                    return viewHolderOnCreateViewHolder;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$addExternalAttachment$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Attachment $attachment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Attachment attachment) {
            super(0);
            this.$attachment = attachment;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatInputAttachments.this.flexInputFragment.f(this.$attachment);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $canCreateThread;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$canCreateThread = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            final Context contextRequireContext = WidgetChatInputAttachments.this.flexInputFragment.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "flexInputFragment.requireContext()");
            final int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.attr.ic_flex_input_image, 0, 2, (Object) null);
            final int i = R.string.attachment_media;
            final int themedDrawableRes$default2 = DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.attr.ic_flex_input_file, 0, 2, (Object) null);
            final int i2 = R.string.attachment_files;
            final int themedDrawableRes$default3 = DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.attr.ic_flex_input_add_a_photo, 0, 2, (Object) null);
            final int i3 = R.string.camera;
            List listMutableListOf = Collections2.mutableListOf(new AddContentPagerAdapter4.a(themedDrawableRes$default, i) { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$1
                @Override // b.b.a.d.AddContentPagerAdapter4.a
                public WidgetChatInputAttachments.DiscordMediaFragment createFragment() {
                    return new WidgetChatInputAttachments.DiscordMediaFragment();
                }
            }, new AddContentPagerAdapter4.a(themedDrawableRes$default2, i2) { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$2
                @Override // b.b.a.d.AddContentPagerAdapter4.a
                public WidgetChatInputAttachments.DiscordFilesFragment createFragment() {
                    return new WidgetChatInputAttachments.DiscordFilesFragment();
                }
            }, new AddContentPagerAdapter4.a(themedDrawableRes$default3, i3) { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$3
                @Override // b.b.a.d.AddContentPagerAdapter4.a
                public CameraFragment createFragment() {
                    return new CameraFragment();
                }
            });
            if (this.$canCreateThread) {
                final int themedDrawableRes$default4 = DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.attr.ic_flex_input_create_thread, 0, 2, (Object) null);
                final int i4 = R.string.create_thread;
                listMutableListOf.add(new AddContentPagerAdapter4.a(themedDrawableRes$default4, i4) { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1$page$1
                    @Override // b.b.a.d.AddContentPagerAdapter4.a
                    public Fragment createFragment() {
                        return new Fragment();
                    }
                });
            }
            FlexInputFragment flexInputFragment = WidgetChatInputAttachments.this.flexInputFragment;
            Object[] array = listMutableListOf.toArray(new AddContentPagerAdapter4.a[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            AddContentPagerAdapter4.a[] aVarArr = (AddContentPagerAdapter4.a[]) array;
            Objects.requireNonNull(flexInputFragment);
            Intrinsics3.checkNotNullParameter(aVarArr, "pageSuppliers");
            flexInputFragment.r = aVarArr;
            Iterator<Function0<Unit>> it = flexInputFragment.onContentPagesInitializedUpdates.iterator();
            while (it.hasNext()) {
                it.next().invoke();
            }
            flexInputFragment.onContentPagesInitializedUpdates.clear();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppFragment $fragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AppFragment appFragment) {
            super(0);
            this.$fragment = appFragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatInputAttachments.this.configureFlexInputContentPages(false);
            FlexInputFragment flexInputFragment = WidgetChatInputAttachments.this.flexInputFragment;
            FileManager fileManager = this.$fragment.getFileManager();
            Objects.requireNonNull(flexInputFragment);
            Intrinsics3.checkNotNullParameter(fileManager, "<set-?>");
            flexInputFragment.fileManager = fileManager;
            flexInputFragment.keyboardManager = new KeyboardManager() { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$1
                @Override // b.b.a.f.KeyboardManager
                public void requestDisplay(View view) {
                    Intrinsics3.checkNotNullParameter(view, "view");
                    this.this$0.$fragment.showKeyboard(view);
                }

                @Override // b.b.a.f.KeyboardManager
                public void requestHide() {
                    WidgetChatInputAttachments.AnonymousClass1 anonymousClass1 = this.this$0;
                    anonymousClass1.$fragment.hideKeyboard(WidgetChatInputAttachments.this.flexInputFragment.l());
                }
            };
            WidgetChatInputAttachments.this.flexInputFragment.l().setInputContentHandler(new WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$2(this));
            AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapterCreatePreviewAdapter = WidgetChatInputAttachments.this.createPreviewAdapter(this.$fragment.getContext());
            Intrinsics3.checkNotNullParameter(attachmentPreviewAdapterCreatePreviewAdapter, "previewAdapter");
            attachmentPreviewAdapterCreatePreviewAdapter.selectionAggregator.initFrom((SelectionAggregator<T>) flexInputFragment.b());
            flexInputFragment.attachmentPreviewAdapter = attachmentPreviewAdapterCreatePreviewAdapter;
            RecyclerView recyclerView = flexInputFragment.j().d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.attachmentPreviewList");
            AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = flexInputFragment.attachmentPreviewAdapter;
            if (attachmentPreviewAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
            }
            recyclerView.setAdapter(attachmentPreviewAdapter);
            WidgetChatInputAttachments widgetChatInputAttachments = WidgetChatInputAttachments.this;
            FragmentManager childFragmentManager = this.$fragment.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            Fragment fragmentCreateAndConfigureExpressionFragment = widgetChatInputAttachments.createAndConfigureExpressionFragment(childFragmentManager, WidgetChatInputAttachments.this.flexInputFragment.l());
            if (fragmentCreateAndConfigureExpressionFragment == null) {
                return;
            }
            flexInputFragment.getChildFragmentManager().beginTransaction().replace(com.lytefast.flexinput.R.f.expression_tray_container, fragmentCreateAndConfigureExpressionFragment, fragmentCreateAndConfigureExpressionFragment.getClass().getSimpleName()).commit();
            AppCompatImageButton appCompatImageButton = flexInputFragment.j().i;
            Intrinsics3.checkNotNullExpressionValue(appCompatImageButton, "binding.expressionBtn");
            appCompatImageButton.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createAndConfigureExpressionFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FlexInputViewModel flexInputViewModel = WidgetChatInputAttachments.this.flexInputFragment.viewModel;
            if (flexInputViewModel != null) {
                flexInputViewModel.hideExpressionTray();
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class AnonymousClass1<T> extends Lambda implements Function1<AttachmentPreviewAdapter<T>, SelectionAggregator<T>> {
        public final /* synthetic */ Context $context;

        /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
        public static final class C02531 extends SelectionAggregator<T> {
            public final /* synthetic */ AttachmentPreviewAdapter $previewAdapter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02531(AttachmentPreviewAdapter attachmentPreviewAdapter, AttachmentPreviewAdapter attachmentPreviewAdapter2) {
                super(attachmentPreviewAdapter2, null, null, null, 14, null);
                this.$previewAdapter = attachmentPreviewAdapter;
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)V */
            private final void track(Attachment attachment) {
                String source = attachment instanceof SourcedAttachment ? ((SourcedAttachment) attachment).getSource() : AnalyticsTracker.ATTACHMENT_SOURCE_PICKER;
                try {
                    int size = WidgetChatInputAttachments.this.flexInputFragment.b().getSize();
                    Context context = AnonymousClass1.this.$context;
                    AnalyticsTracker.addAttachment(source, AttachmentUtils.getMimeType(attachment, context != null ? context.getContentResolver() : null), size);
                } catch (Throwable th) {
                    AppLog.g.i("Analytic error on attachment update", th);
                }
            }

            @Override // com.lytefast.flexinput.utils.SelectionAggregator
            public void registerSelectionCoordinatorInternal(SelectionCoordinator<T, ?> selectionCoordinator) {
                Intrinsics3.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
                super.registerSelectionCoordinatorInternal(selectionCoordinator);
                final SelectionCoordinator.ItemSelectionListener<? super T> itemSelectionListener = selectionCoordinator.itemSelectionListener;
                SelectionCoordinator.ItemSelectionListener<T> itemSelectionListener2 = new SelectionCoordinator.ItemSelectionListener<T>(itemSelectionListener) { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1
                    private final /* synthetic */ SelectionCoordinator.ItemSelectionListener<? super T> $$delegate_0;
                    public final /* synthetic */ SelectionCoordinator.ItemSelectionListener $oldItemSelectionListener;

                    {
                        this.$oldItemSelectionListener = itemSelectionListener;
                        this.$$delegate_0 = itemSelectionListener;
                    }

                    /* JADX WARN: Incorrect types in method signature: (TT;)V */
                    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
                    public void onItemUnselected(Attachment item) {
                        Intrinsics3.checkNotNullParameter(item, "item");
                        this.$$delegate_0.onItemUnselected(item);
                    }

                    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
                    public void unregister() {
                        this.$$delegate_0.unregister();
                    }

                    /* JADX WARN: Incorrect types in method signature: (TT;)V */
                    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
                    public void onItemSelected(Attachment item) {
                        Intrinsics3.checkNotNullParameter(item, "item");
                        this.this$0.track(item);
                        this.$oldItemSelectionListener.onItemSelected(item);
                    }
                };
                Intrinsics3.checkNotNullParameter(itemSelectionListener2, "<set-?>");
                selectionCoordinator.itemSelectionListener = itemSelectionListener2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public final SelectionAggregator<T> invoke(AttachmentPreviewAdapter<T> attachmentPreviewAdapter) {
            Intrinsics3.checkNotNullParameter(attachmentPreviewAdapter, "previewAdapter");
            return new C02531(attachmentPreviewAdapter, attachmentPreviewAdapter);
        }
    }

    public WidgetChatInputAttachments(FlexInputFragment flexInputFragment) {
        Intrinsics3.checkNotNullParameter(flexInputFragment, "flexInputFragment");
        this.flexInputFragment = flexInputFragment;
    }

    private final Fragment createAndConfigureExpressionFragment(FragmentManager fragmentManager, final TextView chatInput) {
        EmojiPickerListener emojiPickerListener = new EmojiPickerListener() { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1
            @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
            public void onEmojiPicked(Emoji emoji) {
                Intrinsics3.checkNotNullParameter(emoji, "emoji");
                FlexInputFragment flexInputFragment = this.this$0.flexInputFragment;
                String chatInputText = emoji.getChatInputText();
                Intrinsics3.checkNotNullExpressionValue(chatInputText, "emoji.chatInputText");
                Objects.requireNonNull(flexInputFragment);
                Intrinsics3.checkNotNullParameter(chatInputText, "emojiText");
                FlexInputViewModel flexInputViewModel = flexInputFragment.viewModel;
                if (flexInputViewModel != null) {
                    flexInputViewModel.onInputTextAppended(chatInputText + ' ');
                }
            }
        };
        StickerPickerListener stickerPickerListener = new StickerPickerListener() { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1
            @Override // com.discord.widgets.chat.input.sticker.StickerPickerListener
            public void onStickerPicked(Sticker sticker) {
                Intrinsics3.checkNotNullParameter(sticker, "sticker");
                FlexInputViewModel flexInputViewModel = this.this$0.flexInputFragment.viewModel;
                if (flexInputViewModel != null) {
                    flexInputViewModel.hideExpressionTray();
                }
            }
        };
        OnBackspacePressedListener onBackspacePressedListener = new OnBackspacePressedListener() { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1
            @Override // com.discord.widgets.chat.input.OnBackspacePressedListener
            public void onBackspacePressed() {
                chatInput.dispatchKeyEvent(new KeyEvent(0, 67));
            }
        };
        Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(R.id.expression_tray_container);
        if (!(fragmentFindFragmentById instanceof WidgetExpressionTray)) {
            fragmentFindFragmentById = null;
        }
        WidgetExpressionTray widgetExpressionTray = (WidgetExpressionTray) fragmentFindFragmentById;
        if (widgetExpressionTray == null) {
            widgetExpressionTray = new WidgetExpressionTray();
        }
        widgetExpressionTray.setEmojiPickerListener(emojiPickerListener);
        widgetExpressionTray.setStickerPickerListener(stickerPickerListener);
        widgetExpressionTray.setOnBackspacePressedListener(onBackspacePressedListener);
        widgetExpressionTray.setOnEmojiSearchOpenedListener(new AnonymousClass1());
        return widgetExpressionTray;
    }

    private final <T extends Attachment<? extends Object>> AttachmentPreviewAdapter<T> createPreviewAdapter(Context context) {
        WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1 widgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1 = new WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1(this);
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-10_android_attachment_bottom_sheet", true);
        return new AttachmentPreviewAdapter<>(userExperiment != null && userExperiment.getBucket() == 1, widgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1, new AnonymousClass1(context));
    }

    private final void setAttachmentFromPicker(Context context, InputContentInfoCompat inputContentInfoCompat) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {
            this.flexInputFragment.f(new SourcedAttachment(Attachment.INSTANCE.c(inputContentInfoCompat, contentResolver, true, FormatUtils.b(context, R.string.attachment_filename_unknown, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null).toString()), AnalyticsTracker.ATTACHMENT_SOURCE_KEYBOARD));
        }
    }

    public final void addExternalAttachment(Attachment<? extends Object> attachment) {
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        this.flexInputFragment.i(new AnonymousClass1(attachment));
    }

    public final void configureFlexInputContentPages(boolean canCreateThread) {
        this.flexInputFragment.i(new AnonymousClass1(canCreateThread));
    }

    public final void configureFlexInputFragment(AppFragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        this.flexInputFragment.i(new AnonymousClass1(fragment));
        fragment.setOnBackPressed(new Func0<Boolean>() { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments.configureFlexInputFragment.2
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                FlexInputViewModel flexInputViewModel = WidgetChatInputAttachments.this.flexInputFragment.viewModel;
                Boolean boolValueOf = flexInputViewModel != null ? Boolean.valueOf(flexInputViewModel.hideExpressionTray()) : null;
                return boolValueOf != null ? boolValueOf : Boolean.FALSE;
            }
        }, 1);
    }

    public final void setInputListener(FlexInputListener inputListener) {
        Intrinsics3.checkNotNullParameter(inputListener, "inputListener");
        FlexInputFragment flexInputFragment = this.flexInputFragment;
        Objects.requireNonNull(flexInputFragment);
        Intrinsics3.checkNotNullParameter(inputListener, "inputListener");
        flexInputFragment.inputListener = inputListener;
    }

    public final void setViewModel(FlexInputViewModel viewModel) {
        this.flexInputFragment.viewModel = viewModel;
    }
}
