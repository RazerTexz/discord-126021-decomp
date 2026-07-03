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
import com.discord.C5419R;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.widgets.chat.input.WidgetChatInputAttachments;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.expression.WidgetExpressionTray;
import com.discord.widgets.chat.input.sticker.StickerPickerListener;
import com.google.android.material.button.MaterialButton;
import com.lytefast.flexinput.C11170R;
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
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C1077w4;
import p007b.p008a.p027k.C1107b;
import p007b.p076b.p077a.p079d.C1434d;
import p007b.p076b.p077a.p081f.InterfaceC1447a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments {
    private final FlexInputFragment flexInputFragment;

    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class DiscordFilesFragment extends FilesFragment {
        @Override // com.lytefast.flexinput.fragment.FilesFragment
        public EmptyListAdapter newPermissionsRequestAdapter(View.OnClickListener onClickListener) {
            C12238m.checkNotNullParameter(onClickListener, "onClickListener");
            return new PermissionsEmptyListAdapter(C5419R.layout.widget_chat_input_perm_req_files, C5419R.id.action_btn, onClickListener);
        }
    }

    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class DiscordMediaFragment extends MediaFragment {
        @Override // com.lytefast.flexinput.fragment.MediaFragment
        public EmptyListAdapter newPermissionsRequestAdapter(View.OnClickListener onClickListener) {
            C12238m.checkNotNullParameter(onClickListener, "onClickListener");
            return new PermissionsEmptyListAdapter(C5419R.layout.widget_chat_input_perm_req_files, C5419R.id.action_btn, onClickListener);
        }
    }

    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class PermissionsEmptyListAdapter extends EmptyListAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PermissionsEmptyListAdapter(@LayoutRes int i, @IdRes int i2, View.OnClickListener onClickListener) {
            super(i, i2, onClickListener);
            C12238m.checkNotNullParameter(onClickListener, "onClickListener");
        }

        @Override // com.lytefast.flexinput.adapters.EmptyListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public EmptyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            C12238m.checkNotNullParameter(parent, "parent");
            EmptyListAdapter.ViewHolder viewHolderOnCreateViewHolder = super.onCreateViewHolder(parent, viewType);
            View view = viewHolderOnCreateViewHolder.itemView;
            int i = C5419R.id.action_btn;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.action_btn);
            if (materialButton != null) {
                i = C5419R.id.perm_req_text;
                TextView textView = (TextView) view.findViewById(C5419R.id.perm_req_text);
                if (textView != null) {
                    C12238m.checkNotNullExpressionValue(new C1077w4((LinearLayout) view, materialButton, textView), "WidgetChatInputPermReqFi…ing.bind(holder.itemView)");
                    C12238m.checkNotNullExpressionValue(textView, "binding.permReqText");
                    C1107b.m221m(textView, C5419R.string.system_permission_request_files, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
                    return viewHolderOnCreateViewHolder;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$addExternalAttachment$1 */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class C77351 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Attachment $attachment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77351(Attachment attachment) {
            super(0);
            this.$attachment = attachment;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatInputAttachments.this.flexInputFragment.mo397f(this.$attachment);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1 */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class C77361 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ boolean $canCreateThread;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77361(boolean z2) {
            super(0);
            this.$canCreateThread = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            final Context contextRequireContext = WidgetChatInputAttachments.this.flexInputFragment.requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "flexInputFragment.requireContext()");
            final int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(contextRequireContext, C5419R.attr.ic_flex_input_image, 0, 2, (Object) null);
            final int i = C5419R.string.attachment_media;
            final int themedDrawableRes$default2 = DrawableCompat.getThemedDrawableRes$default(contextRequireContext, C5419R.attr.ic_flex_input_file, 0, 2, (Object) null);
            final int i2 = C5419R.string.attachment_files;
            final int themedDrawableRes$default3 = DrawableCompat.getThemedDrawableRes$default(contextRequireContext, C5419R.attr.ic_flex_input_add_a_photo, 0, 2, (Object) null);
            final int i3 = C5419R.string.camera;
            List listMutableListOf = C12147n.mutableListOf(new C1434d.a(themedDrawableRes$default, i) { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$1
                @Override // p007b.p076b.p077a.p079d.C1434d.a
                public WidgetChatInputAttachments.DiscordMediaFragment createFragment() {
                    return new WidgetChatInputAttachments.DiscordMediaFragment();
                }
            }, new C1434d.a(themedDrawableRes$default2, i2) { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$2
                @Override // p007b.p076b.p077a.p079d.C1434d.a
                public WidgetChatInputAttachments.DiscordFilesFragment createFragment() {
                    return new WidgetChatInputAttachments.DiscordFilesFragment();
                }
            }, new C1434d.a(themedDrawableRes$default3, i3) { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$3
                @Override // p007b.p076b.p077a.p079d.C1434d.a
                public CameraFragment createFragment() {
                    return new CameraFragment();
                }
            });
            if (this.$canCreateThread) {
                final int themedDrawableRes$default4 = DrawableCompat.getThemedDrawableRes$default(contextRequireContext, C5419R.attr.ic_flex_input_create_thread, 0, 2, (Object) null);
                final int i4 = C5419R.string.create_thread;
                listMutableListOf.add(new C1434d.a(themedDrawableRes$default4, i4) { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1$page$1
                    @Override // p007b.p076b.p077a.p079d.C1434d.a
                    public Fragment createFragment() {
                        return new Fragment();
                    }
                });
            }
            FlexInputFragment flexInputFragment = WidgetChatInputAttachments.this.flexInputFragment;
            Object[] array = listMutableListOf.toArray(new C1434d.a[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            C1434d.a[] aVarArr = (C1434d.a[]) array;
            Objects.requireNonNull(flexInputFragment);
            C12238m.checkNotNullParameter(aVarArr, "pageSuppliers");
            flexInputFragment.f22062r = aVarArr;
            Iterator<Function0<Unit>> it = flexInputFragment.onContentPagesInitializedUpdates.iterator();
            while (it.hasNext()) {
                it.next().invoke();
            }
            flexInputFragment.onContentPagesInitializedUpdates.clear();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputFragment$1 */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class C77411 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ AppFragment $fragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77411(AppFragment appFragment) {
            super(0);
            this.$fragment = appFragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatInputAttachments.this.configureFlexInputContentPages(false);
            FlexInputFragment flexInputFragment = WidgetChatInputAttachments.this.flexInputFragment;
            FileManager fileManager = this.$fragment.getFileManager();
            Objects.requireNonNull(flexInputFragment);
            C12238m.checkNotNullParameter(fileManager, "<set-?>");
            flexInputFragment.fileManager = fileManager;
            flexInputFragment.keyboardManager = new InterfaceC1447a() { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$1
                @Override // p007b.p076b.p077a.p081f.InterfaceC1447a
                public void requestDisplay(View view) {
                    C12238m.checkNotNullParameter(view, "view");
                    this.this$0.$fragment.showKeyboard(view);
                }

                @Override // p007b.p076b.p077a.p081f.InterfaceC1447a
                public void requestHide() {
                    WidgetChatInputAttachments.C77411 c77411 = this.this$0;
                    c77411.$fragment.hideKeyboard(WidgetChatInputAttachments.this.flexInputFragment.m9293l());
                }
            };
            WidgetChatInputAttachments.this.flexInputFragment.m9293l().setInputContentHandler(new C7743xe5e506b3(this));
            AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapterCreatePreviewAdapter = WidgetChatInputAttachments.this.createPreviewAdapter(this.$fragment.getContext());
            C12238m.checkNotNullParameter(attachmentPreviewAdapterCreatePreviewAdapter, "previewAdapter");
            attachmentPreviewAdapterCreatePreviewAdapter.selectionAggregator.initFrom((SelectionAggregator<T>) flexInputFragment.mo396b());
            flexInputFragment.attachmentPreviewAdapter = attachmentPreviewAdapterCreatePreviewAdapter;
            RecyclerView recyclerView = flexInputFragment.m9291j().f2175d;
            C12238m.checkNotNullExpressionValue(recyclerView, "binding.attachmentPreviewList");
            AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = flexInputFragment.attachmentPreviewAdapter;
            if (attachmentPreviewAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
            }
            recyclerView.setAdapter(attachmentPreviewAdapter);
            WidgetChatInputAttachments widgetChatInputAttachments = WidgetChatInputAttachments.this;
            FragmentManager childFragmentManager = this.$fragment.getChildFragmentManager();
            C12238m.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            Fragment fragmentCreateAndConfigureExpressionFragment = widgetChatInputAttachments.createAndConfigureExpressionFragment(childFragmentManager, WidgetChatInputAttachments.this.flexInputFragment.m9293l());
            if (fragmentCreateAndConfigureExpressionFragment == null) {
                return;
            }
            flexInputFragment.getChildFragmentManager().beginTransaction().replace(C11170R.f.expression_tray_container, fragmentCreateAndConfigureExpressionFragment, fragmentCreateAndConfigureExpressionFragment.getClass().getSimpleName()).commit();
            AppCompatImageButton appCompatImageButton = flexInputFragment.m9291j().f2180i;
            C12238m.checkNotNullExpressionValue(appCompatImageButton, "binding.expressionBtn");
            appCompatImageButton.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createAndConfigureExpressionFragment$1 */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class C77451 extends AbstractC12240o implements Function0<Unit> {
        public C77451() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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
    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$1 */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class C77491<T> extends AbstractC12240o implements Function1<AttachmentPreviewAdapter<T>, SelectionAggregator<T>> {
        public final /* synthetic */ Context $context;

        /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
        public static final class AnonymousClass1 extends SelectionAggregator<T> {
            public final /* synthetic */ AttachmentPreviewAdapter $previewAdapter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(AttachmentPreviewAdapter attachmentPreviewAdapter, AttachmentPreviewAdapter attachmentPreviewAdapter2) {
                super(attachmentPreviewAdapter2, null, null, null, 14, null);
                this.$previewAdapter = attachmentPreviewAdapter;
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)V */
            private final void track(Attachment attachment) {
                String source = attachment instanceof SourcedAttachment ? ((SourcedAttachment) attachment).getSource() : AnalyticsTracker.ATTACHMENT_SOURCE_PICKER;
                try {
                    int size = WidgetChatInputAttachments.this.flexInputFragment.mo396b().getSize();
                    Context context = C77491.this.$context;
                    AnalyticsTracker.addAttachment(source, AttachmentUtilsKt.getMimeType(attachment, context != null ? context.getContentResolver() : null), size);
                } catch (Throwable th) {
                    AppLog.f14950g.mo8367i("Analytic error on attachment update", th);
                }
            }

            @Override // com.lytefast.flexinput.utils.SelectionAggregator
            public void registerSelectionCoordinatorInternal(SelectionCoordinator<T, ?> selectionCoordinator) {
                C12238m.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
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
                        C12238m.checkNotNullParameter(item, "item");
                        this.$$delegate_0.onItemUnselected(item);
                    }

                    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
                    public void unregister() {
                        this.$$delegate_0.unregister();
                    }

                    /* JADX WARN: Incorrect types in method signature: (TT;)V */
                    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
                    public void onItemSelected(Attachment item) {
                        C12238m.checkNotNullParameter(item, "item");
                        this.this$0.track(item);
                        this.$oldItemSelectionListener.onItemSelected(item);
                    }
                };
                C12238m.checkNotNullParameter(itemSelectionListener2, "<set-?>");
                selectionCoordinator.itemSelectionListener = itemSelectionListener2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77491(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public final SelectionAggregator<T> invoke(AttachmentPreviewAdapter<T> attachmentPreviewAdapter) {
            C12238m.checkNotNullParameter(attachmentPreviewAdapter, "previewAdapter");
            return new AnonymousClass1(attachmentPreviewAdapter, attachmentPreviewAdapter);
        }
    }

    public WidgetChatInputAttachments(FlexInputFragment flexInputFragment) {
        C12238m.checkNotNullParameter(flexInputFragment, "flexInputFragment");
        this.flexInputFragment = flexInputFragment;
    }

    private final Fragment createAndConfigureExpressionFragment(FragmentManager fragmentManager, final TextView chatInput) {
        EmojiPickerListener emojiPickerListener = new EmojiPickerListener() { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1
            @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
            public void onEmojiPicked(Emoji emoji) {
                C12238m.checkNotNullParameter(emoji, "emoji");
                FlexInputFragment flexInputFragment = this.this$0.flexInputFragment;
                String chatInputText = emoji.getChatInputText();
                C12238m.checkNotNullExpressionValue(chatInputText, "emoji.chatInputText");
                Objects.requireNonNull(flexInputFragment);
                C12238m.checkNotNullParameter(chatInputText, "emojiText");
                FlexInputViewModel flexInputViewModel = flexInputFragment.viewModel;
                if (flexInputViewModel != null) {
                    flexInputViewModel.onInputTextAppended(chatInputText + ' ');
                }
            }
        };
        StickerPickerListener stickerPickerListener = new StickerPickerListener() { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1
            @Override // com.discord.widgets.chat.input.sticker.StickerPickerListener
            public void onStickerPicked(Sticker sticker) {
                C12238m.checkNotNullParameter(sticker, "sticker");
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
        Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(C5419R.id.expression_tray_container);
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
        widgetExpressionTray.setOnEmojiSearchOpenedListener(new C77451());
        return widgetExpressionTray;
    }

    private final <T extends Attachment<? extends Object>> AttachmentPreviewAdapter<T> createPreviewAdapter(Context context) {
        C7751xc61f589 c7751xc61f589 = new C7751xc61f589(this);
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-10_android_attachment_bottom_sheet", true);
        return new AttachmentPreviewAdapter<>(userExperiment != null && userExperiment.getBucket() == 1, c7751xc61f589, new C77491(context));
    }

    private final void setAttachmentFromPicker(Context context, InputContentInfoCompat inputContentInfoCompat) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {
            this.flexInputFragment.mo397f(new SourcedAttachment(Attachment.INSTANCE.m9297c(inputContentInfoCompat, contentResolver, true, C1107b.m216h(context, C5419R.string.attachment_filename_unknown, new Object[0], null, 4).toString()), AnalyticsTracker.ATTACHMENT_SOURCE_KEYBOARD));
        }
    }

    public final void addExternalAttachment(Attachment<? extends Object> attachment) {
        C12238m.checkNotNullParameter(attachment, "attachment");
        this.flexInputFragment.m9290i(new C77351(attachment));
    }

    public final void configureFlexInputContentPages(boolean canCreateThread) {
        this.flexInputFragment.m9290i(new C77361(canCreateThread));
    }

    public final void configureFlexInputFragment(AppFragment fragment) {
        C12238m.checkNotNullParameter(fragment, "fragment");
        this.flexInputFragment.m9290i(new C77411(fragment));
        fragment.setOnBackPressed(new Func0<Boolean>() { // from class: com.discord.widgets.chat.input.WidgetChatInputAttachments.configureFlexInputFragment.2
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                FlexInputViewModel flexInputViewModel = WidgetChatInputAttachments.this.flexInputFragment.viewModel;
                Boolean boolValueOf = flexInputViewModel != null ? Boolean.valueOf(flexInputViewModel.hideExpressionTray()) : null;
                return boolValueOf != null ? boolValueOf : Boolean.FALSE;
            }
        }, 1);
    }

    public final void setInputListener(FlexInputListener inputListener) {
        C12238m.checkNotNullParameter(inputListener, "inputListener");
        FlexInputFragment flexInputFragment = this.flexInputFragment;
        Objects.requireNonNull(flexInputFragment);
        C12238m.checkNotNullParameter(inputListener, "inputListener");
        flexInputFragment.inputListener = inputListener;
    }

    public final void setViewModel(FlexInputViewModel viewModel) {
        this.flexInputFragment.viewModel = viewModel;
    }
}
