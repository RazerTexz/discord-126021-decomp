package com.discord.widgets.chat.list;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.PublishMessageDialogBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.list.PublishActionDialogViewModel;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialog extends AppDialog {
    private static final String ARG_THEME_ID = "theme_id";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> onSuccess;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(PublishActionDialog.class, "binding", "getBinding()Lcom/discord/databinding/PublishMessageDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: PublishActionDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long messageId, long channelId, Function0<Unit> onSuccess, Integer dialogTheme) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            PublishActionDialog publishActionDialog = new PublishActionDialog();
            if (onSuccess != null) {
                publishActionDialog.onSuccess = onSuccess;
            }
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            if (dialogTheme != null) {
                bundleT.putInt(PublishActionDialog.ARG_THEME_ID, dialogTheme.intValue());
            }
            publishActionDialog.setArguments(bundleT);
            publishActionDialog.show(fragmentManager, PublishActionDialog.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: PublishActionDialog.kt */
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
            PublishActionDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: PublishActionDialog.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<PublishActionDialogViewModel.ViewState, Unit> {
        public AnonymousClass1(PublishActionDialog publishActionDialog) {
            super(1, publishActionDialog, PublishActionDialog.class, "updateView", "updateView(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PublishActionDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PublishActionDialogViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((PublishActionDialog) this.receiver).updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: PublishActionDialog.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<PublishActionDialogViewModel.Event, Unit> {
        public AnonymousClass2(PublishActionDialog publishActionDialog) {
            super(1, publishActionDialog, PublishActionDialog.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PublishActionDialogViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PublishActionDialogViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((PublishActionDialog) this.receiver).handleEvent(event);
        }
    }

    public PublishActionDialog() {
        super(R.layout.publish_message_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, PublishActionDialog2.INSTANCE, null, 2, null);
        PublishActionDialog3 publishActionDialog3 = new PublishActionDialog3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(PublishActionDialogViewModel.class), new PublishActionDialog$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(publishActionDialog3));
    }

    private final PublishMessageDialogBinding getBinding() {
        return (PublishMessageDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final PublishActionDialogViewModel getViewModel() {
        return (PublishActionDialogViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(PublishActionDialogViewModel.Event event) {
        if (event instanceof PublishActionDialogViewModel.Event.Success) {
            AppToast.i(this, R.string.message_published, 0, 4);
        } else if (event instanceof PublishActionDialogViewModel.Event.Failure) {
            AppToast.i(this, R.string.publish_followed_news_generic_body, 0, 4);
        }
        dismiss();
    }

    private final void renderHasFollowers(PublishActionDialogViewModel.ViewState.LoadedHasFollowers viewState) {
        TextView textView = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        FormatUtils.m(textView, R.string.publish_followed_news_body_reach, new Object[]{String.valueOf(viewState.getFollowerStats().getGuildsFollowing())}, (4 & 4) != 0 ? FormatUtils.g.j : null);
    }

    private final void renderLoading() {
        TextView textView = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        FormatUtils.m(textView, R.string.loading, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
    }

    private final void renderNoFollowers() {
        TextView textView = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        FormatUtils.m(textView, R.string.publish_followed_news_body, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
    }

    public static final void show(FragmentManager fragmentManager, long j, long j2, Function0<Unit> function0, Integer num) {
        INSTANCE.show(fragmentManager, j, j2, function0, num);
    }

    private final void updateView(PublishActionDialogViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, PublishActionDialogViewModel.ViewState.Loading.INSTANCE)) {
            renderLoading();
        } else if (Intrinsics3.areEqual(viewState, PublishActionDialogViewModel.ViewState.LoadedNoFollowers.INSTANCE)) {
            renderNoFollowers();
        } else if (viewState instanceof PublishActionDialogViewModel.ViewState.LoadedHasFollowers) {
            renderHasFollowers((PublishActionDialogViewModel.ViewState.LoadedHasFollowers) viewState);
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Resources.Theme theme;
        Bundle arguments = getArguments();
        if (arguments != null) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context != null && (theme = context.getTheme()) != null) {
                theme.resolveAttribute(arguments.getInt(ARG_THEME_ID, R.attr.dialogTheme), typedValue, true);
            }
            setStyle(1, typedValue.resourceId);
        }
        return super.onCreateDialog(savedInstanceState);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeHeader");
        FormatUtils.m(textView, R.string.news_channel_publish_bump, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        LinearLayout linearLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.noticeHeaderContainer");
        linearLayout.setVisibility(0);
        TextView textView2 = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.noticeBodyText");
        textView2.setTextAlignment(2);
        TextView textView3 = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.noticeBodyText");
        textView3.setMovementMethod(new WidgetNoticeDialog.ActionLinkMovementMethod(new AnonymousClass1()));
        MaterialButton materialButton = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.noticeOk");
        ViewExtensions.setTextAndVisibilityBy(materialButton, FormatUtils.e(this, R.string.news_channel_publish, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.PublishActionDialog.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PublishActionDialog.this.getViewModel().publishMessage();
                Function0 function0 = PublishActionDialog.this.onSuccess;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        MaterialButton materialButton2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.noticeCancel");
        ViewExtensions.setTextAndVisibilityBy(materialButton2, FormatUtils.e(this, R.string.cancel, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.PublishActionDialog.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PublishActionDialog.this.dismiss();
            }
        });
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) PublishActionDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) PublishActionDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }
}
