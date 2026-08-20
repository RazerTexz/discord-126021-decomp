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
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.PublishMessageDialogBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialog extends AppDialog {
    private static final String ARG_THEME_ID = "theme_id";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> onSuccess;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(PublishActionDialog.class, "binding", "getBinding()Lcom/discord/databinding/PublishMessageDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: PublishActionDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long messageId, long channelId, Function0<Unit> onSuccess, Integer dialogTheme) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            PublishActionDialog publishActionDialog = new PublishActionDialog();
            if (onSuccess != null) {
                publishActionDialog.onSuccess = onSuccess;
            }
            Bundle bundleM832T = C1643a.m832T("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            if (dialogTheme != null) {
                bundleM832T.putInt(PublishActionDialog.ARG_THEME_ID, dialogTheme.intValue());
            }
            publishActionDialog.setArguments(bundleM832T);
            publishActionDialog.show(fragmentManager, PublishActionDialog.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBound$1 */
    /* JADX INFO: compiled from: PublishActionDialog.kt */
    public static final class C79411 extends AbstractC12240o implements Function0<Unit> {
        public C79411() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PublishActionDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: PublishActionDialog.kt */
    public static final /* synthetic */ class C79441 extends C12236k implements Function1<PublishActionDialogViewModel.ViewState, Unit> {
        public C79441(PublishActionDialog publishActionDialog) {
            super(1, publishActionDialog, PublishActionDialog.class, "updateView", "updateView(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PublishActionDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PublishActionDialogViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((PublishActionDialog) this.receiver).updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: PublishActionDialog.kt */
    public static final /* synthetic */ class C79452 extends C12236k implements Function1<PublishActionDialogViewModel.Event, Unit> {
        public C79452(PublishActionDialog publishActionDialog) {
            super(1, publishActionDialog, PublishActionDialog.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PublishActionDialogViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PublishActionDialogViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((PublishActionDialog) this.receiver).handleEvent(event);
        }
    }

    public PublishActionDialog() {
        super(C5419R.layout.publish_message_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, PublishActionDialog$binding$2.INSTANCE, null, 2, null);
        PublishActionDialog$viewModel$2 publishActionDialog$viewModel$2 = new PublishActionDialog$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(PublishActionDialogViewModel.class), new PublishActionDialog$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(publishActionDialog$viewModel$2));
    }

    private final PublishMessageDialogBinding getBinding() {
        return (PublishMessageDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final PublishActionDialogViewModel getViewModel() {
        return (PublishActionDialogViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(PublishActionDialogViewModel.Event event) {
        if (event instanceof PublishActionDialogViewModel.Event.Success) {
            C0876m.m171i(this, C5419R.string.message_published, 0, 4);
        } else if (event instanceof PublishActionDialogViewModel.Event.Failure) {
            C0876m.m171i(this, C5419R.string.publish_followed_news_generic_body, 0, 4);
        }
        dismiss();
    }

    private final void renderHasFollowers(PublishActionDialogViewModel.ViewState.LoadedHasFollowers viewState) {
        TextView textView = getBinding().f15220b;
        C12238m.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        C1107b.m221m(textView, C5419R.string.publish_followed_news_body_reach, new Object[]{String.valueOf(viewState.getFollowerStats().getGuildsFollowing())}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    private final void renderLoading() {
        TextView textView = getBinding().f15220b;
        C12238m.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        C1107b.m221m(textView, C5419R.string.loading, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    private final void renderNoFollowers() {
        TextView textView = getBinding().f15220b;
        C12238m.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        C1107b.m221m(textView, C5419R.string.publish_followed_news_body, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    public static final void show(FragmentManager fragmentManager, long j, long j2, Function0<Unit> function0, Integer num) {
        INSTANCE.show(fragmentManager, j, j2, function0, num);
    }

    private final void updateView(PublishActionDialogViewModel.ViewState viewState) {
        if (C12238m.areEqual(viewState, PublishActionDialogViewModel.ViewState.Loading.INSTANCE)) {
            renderLoading();
        } else if (C12238m.areEqual(viewState, PublishActionDialogViewModel.ViewState.LoadedNoFollowers.INSTANCE)) {
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
                theme.resolveAttribute(arguments.getInt(ARG_THEME_ID, C5419R.attr.dialogTheme), typedValue, true);
            }
            setStyle(1, typedValue.resourceId);
        }
        return super.onCreateDialog(savedInstanceState);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f15222d;
        C12238m.checkNotNullExpressionValue(textView, "binding.noticeHeader");
        C1107b.m221m(textView, C5419R.string.news_channel_publish_bump, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        LinearLayout linearLayout = getBinding().f15223e;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.noticeHeaderContainer");
        linearLayout.setVisibility(0);
        TextView textView2 = getBinding().f15220b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.noticeBodyText");
        textView2.setTextAlignment(2);
        TextView textView3 = getBinding().f15220b;
        C12238m.checkNotNullExpressionValue(textView3, "binding.noticeBodyText");
        textView3.setMovementMethod(new WidgetNoticeDialog.ActionLinkMovementMethod(new C79411()));
        MaterialButton materialButton = getBinding().f15224f;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.noticeOk");
        ViewExtensions.setTextAndVisibilityBy(materialButton, C1107b.m213e(this, C5419R.string.news_channel_publish, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        getBinding().f15224f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.PublishActionDialog.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PublishActionDialog.this.getViewModel().publishMessage();
                Function0 function0 = PublishActionDialog.this.onSuccess;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        MaterialButton materialButton2 = getBinding().f15221c;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.noticeCancel");
        ViewExtensions.setTextAndVisibilityBy(materialButton2, C1107b.m213e(this, C5419R.string.cancel, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        getBinding().f15221c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.PublishActionDialog.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PublishActionDialog.this.dismiss();
            }
        });
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) PublishActionDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C79441(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) PublishActionDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C79452(this));
    }
}
