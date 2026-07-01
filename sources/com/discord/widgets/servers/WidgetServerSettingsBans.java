package com.discord.widgets.servers;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.user.User;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsBanListItemBinding;
import com.discord.databinding.WidgetServerSettingsBansBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelBan;
import com.discord.models.guild.Guild;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.servers.WidgetServerSettingsBans;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OperatorToObservableSortedList;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsBans.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsBansBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final int VIEW_INDEX_BANS_LOADING = 0;
    private static final int VIEW_INDEX_BAN_LIST = 1;
    private static final int VIEW_INDEX_NO_BANS = 2;
    private static final int VIEW_INDEX_NO_RESULTS = 3;
    private Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private AlertDialog dialog;
    private final BehaviorSubject<String> filterPublisher;
    private long guildId;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<Model.BanItem> {
        private Function1<? super ModelBan, Unit> onBanSelectedListener;

        /* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
        public final class BanListItem extends MGRecyclerViewHolder<Adapter, Model.BanItem> {
            private final WidgetServerSettingsBanListItemBinding binding;
            public final /* synthetic */ Adapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BanListItem(Adapter adapter, Adapter adapter2) {
                super(R.layout.widget_server_settings_ban_list_item, adapter2);
                Intrinsics3.checkNotNullParameter(adapter2, "adapter");
                this.this$0 = adapter;
                View view = this.itemView;
                RelativeLayout relativeLayout = (RelativeLayout) view;
                int i = R.id.ban_list_item_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.ban_list_item_avatar);
                if (simpleDraweeView != null) {
                    i = R.id.ban_list_item_name;
                    TextView textView = (TextView) view.findViewById(R.id.ban_list_item_name);
                    if (textView != null) {
                        WidgetServerSettingsBanListItemBinding widgetServerSettingsBanListItemBinding = new WidgetServerSettingsBanListItemBinding((RelativeLayout) view, relativeLayout, simpleDraweeView, textView);
                        Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsBanListItemBinding, "WidgetServerSettingsBanL…temBinding.bind(itemView)");
                        this.binding = widgetServerSettingsBanListItemBinding;
                        return;
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(BanListItem banListItem) {
                return (Adapter) banListItem.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, final Model.BanItem data) {
                User user;
                User user2;
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                TextView textView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.banListItemName");
                ModelBan ban = data.getBan();
                CoreUser coreUser = null;
                textView.setText((ban == null || (user2 = ban.getUser()) == null) ? null : user2.getUsername());
                SimpleDraweeView simpleDraweeView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.banListItemAvatar");
                ModelBan ban2 = data.getBan();
                if (ban2 != null && (user = ban2.getUser()) != null) {
                    coreUser = new CoreUser(user);
                }
                IconUtils.setIcon$default(simpleDraweeView, coreUser, R.dimen.avatar_size_standard, null, null, null, 56, null);
                this.binding.f2543b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsBans$Adapter$BanListItem$onConfigure$2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Function1<ModelBan, Unit> onBanSelectedListener;
                        ModelBan ban3 = data.getBan();
                        if (ban3 == null || (onBanSelectedListener = WidgetServerSettingsBans.Adapter.BanListItem.access$getAdapter$p(this.this$0).getOnBanSelectedListener()) == null) {
                            return;
                        }
                        onBanSelectedListener.invoke(ban3);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        }

        public final Function1<ModelBan, Unit> getOnBanSelectedListener() {
            return this.onBanSelectedListener;
        }

        public final void setOnBanSelectedListener(Function1<? super ModelBan, Unit> function1) {
            this.onBanSelectedListener = function1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BanListItem onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (viewType == 1) {
                return new BanListItem(this, this);
            }
            throw invalidViewTypeException(viewType);
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("BANS", guildId);
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsBans.INTENT_EXTRA_GUILD_ID, guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsBans.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$configureUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelBan, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelBan modelBan) {
            invoke2(modelBan);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelBan modelBan) {
            Intrinsics3.checkNotNullParameter(modelBan, "ban");
            WidgetServerSettingsBans.this.showConfirmUnbanDialog(this.$model.getGuildId(), modelBan);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetServerSettingsBans.this.filterPublisher.onNext(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$onResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerSettingsBans.this.configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$showConfirmUnbanDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ ModelBan $ban;
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$showConfirmUnbanDialog$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
        public static final class C03041 extends Lambda implements Function1<Void, Unit> {
            public static final C03041 INSTANCE = new C03041();

            public C03041() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, ModelBan modelBan) {
            super(1);
            this.$guildId = j;
            this.$ban = modelBan;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().unbanUser(this.$guildId, this.$ban.getUser().getId()), false, 1, null), WidgetServerSettingsBans.this, null, 2, null), (Class<?>) WidgetServerSettingsBans.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), C03041.INSTANCE);
        }
    }

    public WidgetServerSettingsBans() {
        super(R.layout.widget_server_settings_bans);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsBans6.INSTANCE, null, 2, null);
        this.filterPublisher = BehaviorSubject.l0("");
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsBans7.INSTANCE, 3);
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(R.string.bans);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(Model model) throws Exception {
        if ((model != null ? model.getFilteredBannedUsers() : null) == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        configureToolbar(model.getGuildName());
        if (model.isLoading()) {
            AppViewFlipper appViewFlipper = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsBansViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (model.getTotalBannedUsers() == 0) {
            AppViewFlipper appViewFlipper2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsBansViewFlipper");
            appViewFlipper2.setDisplayedChild(2);
        } else if (model.getFilteredBannedUsers().isEmpty()) {
            AppViewFlipper appViewFlipper3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.serverSettingsBansViewFlipper");
            appViewFlipper3.setDisplayedChild(3);
        } else {
            AppViewFlipper appViewFlipper4 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.serverSettingsBansViewFlipper");
            appViewFlipper4.setDisplayedChild(1);
        }
        Adapter adapter = this.adapter;
        if (adapter != null) {
            adapter.setOnBanSelectedListener(new AnonymousClass1(model));
        }
        Adapter adapter2 = this.adapter;
        if (adapter2 != null) {
            adapter2.setData(model.getFilteredBannedUsers());
        }
    }

    public static final void create(Context context, long j) {
        INSTANCE.create(context, j);
    }

    private final WidgetServerSettingsBansBinding getBinding() {
        return (WidgetServerSettingsBansBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void showConfirmUnbanDialog(long guildId, ModelBan ban) {
        String reason = ban.getReason();
        if (reason == null) {
            reason = getString(R.string.no_ban_reason);
        }
        Intrinsics3.checkNotNullExpressionValue(reason, "ban.reason ?: getString(R.string.no_ban_reason)");
        StringBuilder sb = new StringBuilder();
        String string = getString(R.string.ban_reason);
        Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.ban_reason)");
        Locale primaryLocale = new LocaleManager().getPrimaryLocale(getContext());
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        String upperCase = string.toUpperCase(primaryLocale);
        Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        sb.append(upperCase);
        sb.append("\n");
        sb.append(reason);
        WidgetNoticeDialog.Builder dialogAttrTheme = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(requireContext()).setTitle(FormatUtils.b(requireContext(), R.string.unban_user_title, new Object[]{ban.getUser().getUsername()}, (4 & 4) != 0 ? FormatUtils.b.j : null).toString()).setMessage(sb.toString()), R.string.cancel, (Function1) null, 2, (Object) null).setPositiveButton(R.string.unban, new AnonymousClass1(guildId, ban)).setDialogAttrTheme(R.attr.notice_theme_positive_red);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        dialogAttrTheme.show(parentFragmentManager);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.dialog = null;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BehaviorSubject<String> behaviorSubject = this.filterPublisher;
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsBansSearch");
        behaviorSubject.onNext(ViewExtensions.getTextOrEmpty(textInputLayout));
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsBansSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new AnonymousClass1());
        Model.Companion companion = Model.INSTANCE;
        long j = this.guildId;
        BehaviorSubject<String> behaviorSubject2 = this.filterPublisher;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject2, "filterPublisher");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.get(j, behaviorSubject2), this, null, 2, null), (Class<?>) WidgetServerSettingsBans.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2544b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsBansRecycler");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView));
        this.guildId = getMostRecentIntent().getLongExtra(INTENT_EXTRA_GUILD_ID, -1L);
    }

    /* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
    public static final /* data */ class Model {
        public static final int TYPE_BANNED_USER = 1;
        private final List<BanItem> filteredBannedUsers;
        private final long guildId;
        private final String guildName;
        private final boolean isLoading;
        private final int totalBannedUsers;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final ArrayList<BanItem> emptyBansList = new ArrayList<>();

        /* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
        public static final class Companion {
            private Companion() {
            }

            private final Model createLoading(Guild guild) {
                if (guild == null) {
                    return null;
                }
                return new Model(0, Model.emptyBansList, guild.getId(), guild.getName(), true);
            }

            private final Observable<Model> getBanItems(final long guildId, final Observable<String> filterPublisher) {
                Observable<R> observableY = StoreStream.INSTANCE.getBans().observeBans(guildId).Y(new Func1<Map<Long, ? extends ModelBan>, Observable<? extends Model>>() { // from class: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1
                    @Override // j0.k.Func1
                    public final Observable<? extends WidgetServerSettingsBans.Model> call(final Map<Long, ? extends ModelBan> map) {
                        return map == null ? StoreStream.INSTANCE.getGuilds().observeGuild(guildId).G(new Func1<Guild, WidgetServerSettingsBans.Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1.1
                            @Override // j0.k.Func1
                            public final WidgetServerSettingsBans.Model call(Guild guild) {
                                return WidgetServerSettingsBans.Model.INSTANCE.createLoading(guild);
                            }
                        }) : Observable.i(StoreStream.INSTANCE.getGuilds().observeGuild(guildId), new ScalarSynchronousObservable(Integer.valueOf(map.size())), filterPublisher.Y(new Func1<String, Observable<? extends List<WidgetServerSettingsBans.Model.BanItem>>>() { // from class: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1.2
                            @Override // j0.k.Func1
                            public final Observable<? extends List<WidgetServerSettingsBans.Model.BanItem>> call(final String str) {
                                Observable<R> observableG = Observable.B(map.values()).y(new Func1<ModelBan, Boolean>() { // from class: com.discord.widgets.servers.WidgetServerSettingsBans.Model.Companion.getBanItems.1.2.1
                                    @Override // j0.k.Func1
                                    public final Boolean call(ModelBan modelBan) {
                                        Intrinsics3.checkNotNullExpressionValue(modelBan, "it");
                                        String username = modelBan.getUser().getUsername();
                                        String str2 = str;
                                        Intrinsics3.checkNotNullExpressionValue(str2, "filter");
                                        return Boolean.valueOf(Strings4.contains((CharSequence) username, (CharSequence) str2, true));
                                    }
                                }).G(new Func1<ModelBan, WidgetServerSettingsBans.Model.BanItem>() { // from class: com.discord.widgets.servers.WidgetServerSettingsBans.Model.Companion.getBanItems.1.2.2
                                    @Override // j0.k.Func1
                                    public final WidgetServerSettingsBans.Model.BanItem call(ModelBan modelBan) {
                                        return new WidgetServerSettingsBans.Model.BanItem(modelBan);
                                    }
                                });
                                return Observable.h0(new OnSubscribeLift(observableG.j, new OperatorToObservableSortedList(new Func2<WidgetServerSettingsBans.Model.BanItem, WidgetServerSettingsBans.Model.BanItem, Integer>() { // from class: com.discord.widgets.servers.WidgetServerSettingsBans.Model.Companion.getBanItems.1.2.3
                                    @Override // rx.functions.Func2
                                    public final Integer call(WidgetServerSettingsBans.Model.BanItem banItem, WidgetServerSettingsBans.Model.BanItem banItem2) {
                                        User user;
                                        String username;
                                        String username2;
                                        User user2;
                                        ModelBan ban = banItem.getBan();
                                        if (ban == null || (user = ban.getUser()) == null || (username = user.getUsername()) == null) {
                                            return null;
                                        }
                                        ModelBan ban2 = banItem2.getBan();
                                        if (ban2 == null || (user2 = ban2.getUser()) == null || (username2 = user2.getUsername()) == null) {
                                            username2 = "";
                                        }
                                        return Integer.valueOf(StringsJVM.compareTo(username, username2, true));
                                    }
                                }, 10)));
                            }
                        }), new Func3<Guild, Integer, List<WidgetServerSettingsBans.Model.BanItem>, WidgetServerSettingsBans.Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1.3
                            @Override // rx.functions.Func3
                            public final WidgetServerSettingsBans.Model call(Guild guild, Integer num, List<WidgetServerSettingsBans.Model.BanItem> list) {
                                return WidgetServerSettingsBans.Model.INSTANCE.create(guild, num, list);
                            }
                        });
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            private final Observable<Boolean> getCanManageBans(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuilds().observeGuild(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), new Func3<Long, Guild, MeUser, Boolean>() { // from class: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getCanManageBans$1
                    @Override // rx.functions.Func3
                    public final Boolean call(Long l, Guild guild, MeUser meUser) {
                        return Boolean.valueOf((guild == null || l == null) ? false : PermissionUtils.canAndIsElevated(4L, l, meUser.getMfaEnabled(), guild.getMfaLevel()));
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n             …        }\n              }");
                Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
                return observableR;
            }

            public final Model create(Guild guild, Integer totalBannedUsers, List<BanItem> filteredBannedUsers) {
                if (guild == null || totalBannedUsers == null || filteredBannedUsers == null) {
                    return null;
                }
                return new Model(totalBannedUsers.intValue(), filteredBannedUsers, guild.getId(), guild.getName(), false);
            }

            public final Observable<Model> get(final long guildId, final Observable<String> filterPublisher) {
                Intrinsics3.checkNotNullParameter(filterPublisher, "filterPublisher");
                Observable observableY = getCanManageBans(guildId).Y(new Func1<Boolean, Observable<? extends Model>>() { // from class: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public final Observable<? extends WidgetServerSettingsBans.Model> call(Boolean bool) {
                        Intrinsics3.checkNotNullExpressionValue(bool, "canManage");
                        return bool.booleanValue() ? WidgetServerSettingsBans.Model.INSTANCE.getBanItems(guildId, filterPublisher) : new ScalarSynchronousObservable(null);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "getCanManageBans(guildId….just(null)\n            }");
                return observableY;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(int i, List<BanItem> list, long j, String str, boolean z2) {
            this.totalBannedUsers = i;
            this.filteredBannedUsers = list;
            this.guildId = j;
            this.guildName = str;
            this.isLoading = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, int i, List list, long j, String str, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = model.totalBannedUsers;
            }
            if ((i2 & 2) != 0) {
                list = model.filteredBannedUsers;
            }
            List list2 = list;
            if ((i2 & 4) != 0) {
                j = model.guildId;
            }
            long j2 = j;
            if ((i2 & 8) != 0) {
                str = model.guildName;
            }
            String str2 = str;
            if ((i2 & 16) != 0) {
                z2 = model.isLoading;
            }
            return model.copy(i, list2, j2, str2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTotalBannedUsers() {
            return this.totalBannedUsers;
        }

        public final List<BanItem> component2() {
            return this.filteredBannedUsers;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public final Model copy(int totalBannedUsers, List<BanItem> filteredBannedUsers, long guildId, String guildName, boolean isLoading) {
            return new Model(totalBannedUsers, filteredBannedUsers, guildId, guildName, isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.totalBannedUsers == model.totalBannedUsers && Intrinsics3.areEqual(this.filteredBannedUsers, model.filteredBannedUsers) && this.guildId == model.guildId && Intrinsics3.areEqual(this.guildName, model.guildName) && this.isLoading == model.isLoading;
        }

        public final List<BanItem> getFilteredBannedUsers() {
            return this.filteredBannedUsers;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        public final int getTotalBannedUsers() {
            return this.totalBannedUsers;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r1v8, types: [int] */
        public int hashCode() {
            int i = this.totalBannedUsers * 31;
            List<BanItem> list = this.filteredBannedUsers;
            int iA = (b.a(this.guildId) + ((i + (list != null ? list.hashCode() : 0)) * 31)) * 31;
            String str = this.guildName;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.isLoading;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            return iHashCode + r0;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(totalBannedUsers=");
            sbU.append(this.totalBannedUsers);
            sbU.append(", filteredBannedUsers=");
            sbU.append(this.filteredBannedUsers);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", guildName=");
            sbU.append(this.guildName);
            sbU.append(", isLoading=");
            return outline.O(sbU, this.isLoading, ")");
        }

        /* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
        public static final /* data */ class BanItem implements MGRecyclerDataPayload {
            private ModelBan ban;
            private final String key;
            private final int type;

            /* JADX WARN: Multi-variable type inference failed */
            public BanItem() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public BanItem(ModelBan modelBan) {
                User user;
                this.ban = modelBan;
                this.type = 1;
                this.key = String.valueOf((modelBan == null || (user = modelBan.getUser()) == null) ? null : Long.valueOf(user.getId()));
            }

            public static /* synthetic */ BanItem copy$default(BanItem banItem, ModelBan modelBan, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelBan = banItem.ban;
                }
                return banItem.copy(modelBan);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelBan getBan() {
                return this.ban;
            }

            public final BanItem copy(ModelBan ban) {
                return new BanItem(ban);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final BanItem create(ModelBan ban) {
                Intrinsics3.checkNotNullParameter(ban, "ban");
                BanItem banItem = new BanItem(null, 1, 0 == true ? 1 : 0);
                banItem.ban = ban;
                return banItem;
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof BanItem) && Intrinsics3.areEqual(this.ban, ((BanItem) other).ban);
                }
                return true;
            }

            public final ModelBan getBan() {
                return this.ban;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                ModelBan modelBan = this.ban;
                if (modelBan != null) {
                    return modelBan.hashCode();
                }
                return 0;
            }

            public final void setBan(ModelBan modelBan) {
                this.ban = modelBan;
            }

            public String toString() {
                StringBuilder sbU = outline.U("BanItem(ban=");
                sbU.append(this.ban);
                sbU.append(")");
                return sbU.toString();
            }

            public /* synthetic */ BanItem(ModelBan modelBan, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : modelBan);
            }
        }
    }
}
