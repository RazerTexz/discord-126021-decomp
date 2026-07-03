package p007b.p008a.p009a.p013d;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.models.user.User;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.UserNameFormatterKt;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p000.C12788k;
import p007b.p008a.p009a.p013d.C0822f;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C1060u1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.d.a */
/* JADX INFO: compiled from: UserActionsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0817a extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f315j = {C1643a.m846d0(C0817a.class, "binding", "getBinding()Lcom/discord/databinding/UserActionsDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final MGImages.DistinctChangeDetector imagesChangeDetector;

    /* JADX INFO: renamed from: b.a.a.d.a$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f320j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f321k;

        public a(int i, Object obj) {
            this.f320j = i;
            this.f321k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f320j;
            if (i == 0) {
                C0817a c0817a = (C0817a) this.f321k;
                KProperty[] kPropertyArr = C0817a.f315j;
                C0822f c0822fM125h = c0817a.m125h();
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(c0822fM125h.f332m.addRelationship("User Profile", c0822fM125h.f331l, (28 & 4) != 0 ? null : 2, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null), false, 1, null), c0822fM125h, null, 2, null), (Class<?>) C0822f.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C0824h(c0822fM125h)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C0823g(c0822fM125h));
                return;
            }
            if (i == 1) {
                C0817a c0817a2 = (C0817a) this.f321k;
                KProperty[] kPropertyArr2 = C0817a.f315j;
                c0817a2.m125h().removeRelationship(C5419R.string.user_has_been_unblocked);
            } else {
                if (i != 2) {
                    throw null;
                }
                C0817a c0817a3 = (C0817a) this.f321k;
                KProperty[] kPropertyArr3 = C0817a.f315j;
                c0817a3.m125h().removeRelationship(C5419R.string.friend_has_been_deleted);
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: UserActionsDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$c */
    /* JADX INFO: compiled from: UserActionsDialog.kt */
    public static final /* synthetic */ class c extends C12236k implements Function1<View, C1060u1> {

        /* JADX INFO: renamed from: j */
        public static final c f322j = new c();

        public c() {
            super(1, C1060u1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/UserActionsDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C1060u1 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.user_actions_dialog_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(C5419R.id.user_actions_dialog_avatar);
            if (simpleDraweeView != null) {
                i = C5419R.id.user_actions_dialog_block_item;
                TextView textView = (TextView) view2.findViewById(C5419R.id.user_actions_dialog_block_item);
                if (textView != null) {
                    i = C5419R.id.user_actions_dialog_remove_friend_item;
                    TextView textView2 = (TextView) view2.findViewById(C5419R.id.user_actions_dialog_remove_friend_item);
                    if (textView2 != null) {
                        i = C5419R.id.user_actions_dialog_unblock_item;
                        TextView textView3 = (TextView) view2.findViewById(C5419R.id.user_actions_dialog_unblock_item);
                        if (textView3 != null) {
                            i = C5419R.id.user_actions_dialog_user_name;
                            TextView textView4 = (TextView) view2.findViewById(C5419R.id.user_actions_dialog_user_name);
                            if (textView4 != null) {
                                return new C1060u1((LinearLayout) view2, simpleDraweeView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$d */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class d<T, R> implements InterfaceC12589b<Object, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final d f323j = new d();

        @Override // p637j0.p641k.InterfaceC12589b
        public Boolean call(Object obj) {
            return Boolean.valueOf(obj instanceof C0822f.d.a);
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$e */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class e<T, R> implements InterfaceC12589b<Object, T> {

        /* JADX INFO: renamed from: j */
        public static final e f324j = new e();

        @Override // p637j0.p641k.InterfaceC12589b
        public final T call(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.dialogs.useractions.UserActionsDialogViewModel.ViewState.Loaded");
            return (T) ((C0822f.d.a) obj);
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$f */
    /* JADX INFO: compiled from: UserActionsDialog.kt */
    public static final /* synthetic */ class f extends C12236k implements Function1<C0822f.d.a, Unit> {
        public f(C0817a c0817a) {
            super(1, c0817a, C0817a.class, "updateView", "updateView(Lcom/discord/dialogs/useractions/UserActionsDialogViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(C0822f.d.a aVar) {
            C0822f.d.a aVar2 = aVar;
            C12238m.checkNotNullParameter(aVar2, "p1");
            C0817a c0817a = (C0817a) this.receiver;
            KProperty[] kPropertyArr = C0817a.f315j;
            SimpleDraweeView simpleDraweeView = c0817a.m124g().f1281b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.userActionsDialogAvatar");
            IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForUser$default(aVar2.f338a, true, null, 4, null), 0, (Function1) null, c0817a.imagesChangeDetector, 12, (Object) null);
            TextView textView = c0817a.m124g().f1285f;
            C12238m.checkNotNullExpressionValue(textView, "binding.userActionsDialogUserName");
            User user = aVar2.f338a;
            String str = aVar2.f339b;
            Context contextRequireContext = c0817a.requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(UserNameFormatterKt.getSpannableForUserNameWithDiscrim(user, str, contextRequireContext, C5419R.attr.colorHeaderPrimary, C5419R.attr.font_primary_semibold, C5419R.integer.uikit_textsize_large_sp, C5419R.attr.colorTextMuted, C5419R.attr.font_primary_normal, C5419R.integer.uikit_textsize_large_sp));
            TextView textView2 = c0817a.m124g().f1282c;
            C12238m.checkNotNullExpressionValue(textView2, "binding.userActionsDialogBlockItem");
            textView2.setVisibility(aVar2.f340c ? 0 : 8);
            TextView textView3 = c0817a.m124g().f1284e;
            C12238m.checkNotNullExpressionValue(textView3, "binding.userActionsDialogUnblockItem");
            textView3.setVisibility(aVar2.f341d ? 0 : 8);
            TextView textView4 = c0817a.m124g().f1283d;
            C12238m.checkNotNullExpressionValue(textView4, "binding.userActionsDialogRemoveFriendItem");
            textView4.setVisibility(aVar2.f342e ? 0 : 8);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$g */
    /* JADX INFO: compiled from: UserActionsDialog.kt */
    public static final /* synthetic */ class g extends C12236k implements Function1<C0822f.b, Unit> {
        public g(C0817a c0817a) {
            super(1, c0817a, C0817a.class, "handleEvent", "handleEvent(Lcom/discord/dialogs/useractions/UserActionsDialogViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(C0822f.b bVar) {
            C0822f.b bVar2 = bVar;
            C12238m.checkNotNullParameter(bVar2, "p1");
            C0817a c0817a = (C0817a) this.receiver;
            KProperty[] kPropertyArr = C0817a.f315j;
            Objects.requireNonNull(c0817a);
            if (bVar2 instanceof C0822f.b.C13207b) {
                C0876m.m171i(c0817a, ((C0822f.b.C13207b) bVar2).f334a, 0, 4);
                c0817a.dismiss();
            } else if (bVar2 instanceof C0822f.b.a) {
                C0876m.m171i(c0817a, ((C0822f.b.a) bVar2).f333a, 0, 4);
                c0817a.dismiss();
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$h */
    /* JADX INFO: compiled from: UserActionsDialog.kt */
    public static final class h extends AbstractC12240o implements Function0<C0822f> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public C0822f invoke() {
            C0817a c0817a = C0817a.this;
            KProperty[] kPropertyArr = C0817a.f315j;
            return new C0822f(c0817a.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", 0L), C0817a.this.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L), null, null, 12);
        }
    }

    public C0817a() {
        super(C5419R.layout.user_actions_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.f322j, null, 2, null);
        h hVar = new h();
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(C0822f.class), new C12788k(4, c0865g0), new C0869i0(hVar));
        this.imagesChangeDetector = new MGImages.DistinctChangeDetector();
    }

    /* JADX INFO: renamed from: g */
    public final C1060u1 m124g() {
        return (C1060u1) this.binding.getValue((Fragment) this, f315j[0]);
    }

    /* JADX INFO: renamed from: h */
    public final C0822f m125h() {
        return (C0822f) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        m124g().f1282c.setOnClickListener(new a(0, this));
        m124g().f1284e.setOnClickListener(new a(1, this));
        m124g().f1283d.setOnClickListener(new a(2, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<R> observableM11083G = m125h().observeViewState().m11118y(d.f323j).m11083G(e.f324j);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11083G, this, null, 2, null), (Class<?>) C0817a.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new f(this));
        PublishSubject<C0822f.b> publishSubject = m125h().f330k;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(publishSubject, this, null, 2, null), (Class<?>) C0817a.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new g(this));
    }
}
