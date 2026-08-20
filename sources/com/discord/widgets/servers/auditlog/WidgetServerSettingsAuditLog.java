package com.discord.widgets.servers.auditlog;

import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsAuditLogBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.domain.ModelWebhook;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreAuditLog;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.auditlogs.AuditLogChangeUtils;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func6;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsAuditLog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsAuditLogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DIRECTION_DOWN = 1;
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final String INTENT_EXTRA_GUILD_NAME = "GUILD_NAME";
    private static final int RESULTS_VIEW_INDEX_LOGS = 0;
    private static final int RESULTS_VIEW_INDEX_NO_LOGS = 1;
    private static final int VIEW_INDEX_LOGS_CONTENT = 1;
    private static final int VIEW_INDEX_LOGS_LOADING = 0;
    private WidgetServerSettingsAuditLogAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long guildId;
    private boolean loadingAuditLogs;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId, String guildName) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(guildName, "guildName");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("AUDIT_LOG", guildId);
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsAuditLog.INTENT_EXTRA_GUILD_ID, guildId).putExtra(WidgetServerSettingsAuditLog.INTENT_EXTRA_GUILD_NAME, guildName);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_GUILD_NAME, guildName)");
            C0870j.m156d(context, WidgetServerSettingsAuditLog.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
    public static abstract class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
        public static final class Companion {

            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    ModelAuditLogEntry.TargetType.values();
                    int[] iArr = new int[15];
                    $EnumSwitchMapping$0 = iArr;
                    iArr[ModelAuditLogEntry.TargetType.CHANNEL.ordinal()] = 1;
                    iArr[ModelAuditLogEntry.TargetType.CHANNEL_OVERWRITE.ordinal()] = 2;
                    iArr[ModelAuditLogEntry.TargetType.USER.ordinal()] = 3;
                    iArr[ModelAuditLogEntry.TargetType.ROLE.ordinal()] = 4;
                    iArr[ModelAuditLogEntry.TargetType.GUILD.ordinal()] = 5;
                    iArr[ModelAuditLogEntry.TargetType.INVITE.ordinal()] = 6;
                    iArr[ModelAuditLogEntry.TargetType.ALL.ordinal()] = 7;
                    iArr[ModelAuditLogEntry.TargetType.WEBHOOK.ordinal()] = 8;
                    iArr[ModelAuditLogEntry.TargetType.EMOJI.ordinal()] = 9;
                    iArr[ModelAuditLogEntry.TargetType.INTEGRATION.ordinal()] = 10;
                    iArr[ModelAuditLogEntry.TargetType.STAGE_INSTANCE.ordinal()] = 11;
                    iArr[ModelAuditLogEntry.TargetType.GUILD_SCHEDULED_EVENT.ordinal()] = 12;
                    iArr[ModelAuditLogEntry.TargetType.THREAD.ordinal()] = 13;
                    iArr[ModelAuditLogEntry.TargetType.UNKNOWN.ordinal()] = 14;
                    iArr[ModelAuditLogEntry.TargetType.STICKER.ordinal()] = 15;
                }
            }

            private Companion() {
            }

            /* JADX WARN: Code duplicated, block: B:26:0x0072  */
            /* JADX WARN: Code duplicated, block: B:42:0x00ac  */
            private final String resolveChannelName(Map<Long, Channel> channels, ModelAuditLogEntry entry) {
                Object oldValue;
                Object oldValue2;
                Object next;
                ModelAuditLogEntry.Change change;
                Object next2;
                ModelAuditLogEntry.Change change2;
                Channel channel = channels.get(Long.valueOf(entry.getTargetId()));
                if (channel != null) {
                    boolean zM7698v = ChannelUtils.m7698v(channel);
                    if (zM7698v) {
                        StringBuilder sbM829Q = C1643a.m829Q(MentionUtilsKt.CHANNELS_CHAR);
                        sbM829Q.append(ChannelUtils.m7679c(channel));
                        return sbM829Q.toString();
                    }
                    if (zM7698v) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return ChannelUtils.m7679c(channel);
                }
                if (entry.getActionTypeId() == 12) {
                    List<ModelAuditLogEntry.Change> changes = entry.getChanges();
                    if (changes != null) {
                        Iterator<T> it = changes.iterator();
                        do {
                            if (!it.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it.next();
                            change2 = (ModelAuditLogEntry.Change) next2;
                            C12238m.checkNotNullExpressionValue(change2, "it");
                        } while (!C12238m.areEqual(change2.getKey(), ModelAuditLogEntry.CHANGE_KEY_NAME));
                        ModelAuditLogEntry.Change change3 = (ModelAuditLogEntry.Change) next2;
                        if (change3 != null) {
                            oldValue = change3.getOldValue();
                        } else {
                            oldValue = null;
                        }
                    } else {
                        oldValue = null;
                    }
                    if (!(oldValue instanceof String)) {
                        oldValue = null;
                    }
                    String str = (String) oldValue;
                    List<ModelAuditLogEntry.Change> changes2 = entry.getChanges();
                    if (changes2 != null) {
                        Iterator<T> it2 = changes2.iterator();
                        do {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                            change = (ModelAuditLogEntry.Change) next;
                            C12238m.checkNotNullExpressionValue(change, "it");
                        } while (!C12238m.areEqual(change.getKey(), "type"));
                        ModelAuditLogEntry.Change change4 = (ModelAuditLogEntry.Change) next;
                        if (change4 != null) {
                            oldValue2 = change4.getOldValue();
                        } else {
                            oldValue2 = null;
                        }
                    } else {
                        oldValue2 = null;
                    }
                    if (!(oldValue2 instanceof Long)) {
                        oldValue2 = null;
                    }
                    Long l = (Long) oldValue2;
                    if (str != null && l != null) {
                        boolean zM7688l = ChannelUtils.m7688l((int) l.longValue());
                        if (!zM7688l) {
                            if (zM7688l) {
                                throw new NoWhenBranchMatchedException();
                            }
                            return str;
                        }
                        return MentionUtilsKt.CHANNELS_CHAR + str;
                    }
                }
                return null;
            }

            public final Observable<Model> get(final long guildId, final Context context) {
                C12238m.checkNotNullParameter(context, "context");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableM11112r = Observable.m11071f(companion.getAuditLog().observeAuditLogState(guildId), companion.getGuilds().observeGuild(guildId), StoreChannels.observeChannelsForGuild$default(companion.getChannels(), guildId, null, 2, null), ObservableExtensionsKt.leadingEdgeThrottle(companion.getUsers().observeAllUsers(), 3L, TimeUnit.SECONDS), companion.getGuilds().observeRoles(guildId), companion.getGuilds().observeComputed(guildId), new Func6<StoreAuditLog.AuditLogState, Guild, Map<Long, ? extends Channel>, Map<Long, ? extends User>, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Model>() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$Model$Companion$get$1
                    @Override // p658rx.functions.Func6
                    public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLog.Model call(StoreAuditLog.AuditLogState auditLogState, Guild guild, Map<Long, ? extends Channel> map, Map<Long, ? extends User> map2, Map<Long, ? extends GuildRole> map3, Map<Long, ? extends GuildMember> map4) {
                        return call2(auditLogState, guild, (Map<Long, Channel>) map, map2, (Map<Long, GuildRole>) map3, (Map<Long, GuildMember>) map4);
                    }

                    /* JADX WARN: Code duplicated, block: B:29:0x00a8  */
                    /* JADX WARN: Code duplicated, block: B:30:0x00aa  */
                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final WidgetServerSettingsAuditLog.Model call2(StoreAuditLog.AuditLogState auditLogState, Guild guild, Map<Long, Channel> map, Map<Long, ? extends User> map2, Map<Long, GuildRole> map3, Map<Long, GuildMember> map4) {
                        CharSequence string;
                        CharSequence userNameWithDiscriminator$default;
                        Channel channel;
                        CharSequence charSequenceResolveChannelName;
                        Map map5;
                        Map<Long, Channel> map6 = map;
                        if ((auditLogState != null ? auditLogState.getEntries() : null) == null || guild == null) {
                            return WidgetServerSettingsAuditLog.Model.Loading.INSTANCE;
                        }
                        HashMap map7 = new HashMap();
                        map7.putAll(auditLogState.getDeletedTargets());
                        for (ModelAuditLogEntry modelAuditLogEntry : auditLogState.getEntries()) {
                            if (map7.get(modelAuditLogEntry.getTargetType()) == null) {
                                ModelAuditLogEntry.TargetType targetType = modelAuditLogEntry.getTargetType();
                                C12238m.checkNotNullExpressionValue(targetType, "entry.targetType");
                                map7.put(targetType, new HashMap());
                            }
                            ModelAuditLogEntry.TargetType targetType2 = modelAuditLogEntry.getTargetType();
                            if (targetType2 == null) {
                                charSequenceResolveChannelName = null;
                            } else {
                                switch (targetType2) {
                                    case ALL:
                                    case UNKNOWN:
                                    case GUILD:
                                    case INVITE:
                                    case WEBHOOK:
                                    case EMOJI:
                                    case INTEGRATION:
                                    case STAGE_INSTANCE:
                                    case GUILD_SCHEDULED_EVENT:
                                    case STICKER:
                                    case THREAD:
                                        charSequenceResolveChannelName = null;
                                        break;
                                    case CHANNEL:
                                    case CHANNEL_OVERWRITE:
                                        WidgetServerSettingsAuditLog.Model.Companion companion2 = WidgetServerSettingsAuditLog.Model.INSTANCE;
                                        C12238m.checkNotNullExpressionValue(map6, "channels");
                                        charSequenceResolveChannelName = companion2.resolveChannelName(map6, modelAuditLogEntry);
                                        break;
                                    case USER:
                                        User user = map2.get(Long.valueOf(modelAuditLogEntry.getTargetId()));
                                        if (user != null) {
                                            charSequenceResolveChannelName = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
                                        } else {
                                            charSequenceResolveChannelName = null;
                                        }
                                        break;
                                    case ROLE:
                                        GuildRole guildRole = map3.get(Long.valueOf(modelAuditLogEntry.getTargetId()));
                                        if (guildRole != null) {
                                            charSequenceResolveChannelName = guildRole.getName();
                                        } else {
                                            charSequenceResolveChannelName = null;
                                        }
                                        break;
                                    default:
                                        throw new NoWhenBranchMatchedException();
                                }
                            }
                            if (charSequenceResolveChannelName != null && (map5 = (Map) map7.get(modelAuditLogEntry.getTargetType())) != null) {
                            }
                        }
                        ModelAuditLogEntry.TargetType targetType3 = ModelAuditLogEntry.TargetType.CHANNEL;
                        if (map7.get(targetType3) == null) {
                            map7.put(targetType3, new HashMap());
                        }
                        C12238m.checkNotNullExpressionValue(map6, "channels");
                        Iterator<Map.Entry<Long, Channel>> it = map.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                ModelAuditLogEntry.TargetType targetType4 = ModelAuditLogEntry.TargetType.USER;
                                if (map7.get(targetType4) == null) {
                                    map7.put(targetType4, new HashMap());
                                }
                                for (Map.Entry<Long, User> entry : auditLogState.getUsers().entrySet()) {
                                    Map map8 = (Map) map7.get(ModelAuditLogEntry.TargetType.USER);
                                    if (map8 != null) {
                                    }
                                }
                                ModelAuditLogEntry.TargetType targetType5 = ModelAuditLogEntry.TargetType.GUILD;
                                if (map7.get(targetType5) == null) {
                                    map7.put(targetType5, new HashMap());
                                }
                                Map map9 = (Map) map7.get(targetType5);
                                if (map9 != null) {
                                }
                                ModelAuditLogEntry.TargetType targetType6 = ModelAuditLogEntry.TargetType.WEBHOOK;
                                if (map7.get(targetType6) == null) {
                                    map7.put(targetType6, new HashMap());
                                }
                                for (ModelWebhook modelWebhook : auditLogState.getWebhooks()) {
                                    Map map10 = (Map) map7.get(ModelAuditLogEntry.TargetType.WEBHOOK);
                                    if (map10 != null) {
                                    }
                                }
                                ModelAuditLogEntry.TargetType targetType7 = ModelAuditLogEntry.TargetType.INTEGRATION;
                                if (map7.get(targetType7) == null) {
                                    map7.put(targetType7, new HashMap());
                                }
                                for (ModelGuildIntegration modelGuildIntegration : auditLogState.getIntegrations()) {
                                    Map map11 = (Map) map7.get(ModelAuditLogEntry.TargetType.INTEGRATION);
                                    if (map11 != null) {
                                    }
                                }
                                ModelAuditLogEntry.TargetType targetType8 = ModelAuditLogEntry.TargetType.GUILD_SCHEDULED_EVENT;
                                if (map7.get(targetType8) == null) {
                                    map7.put(targetType8, new HashMap());
                                }
                                for (GuildScheduledEvent guildScheduledEvent : auditLogState.getGuildScheduledEvents()) {
                                    Map map12 = (Map) map7.get(ModelAuditLogEntry.TargetType.GUILD_SCHEDULED_EVENT);
                                    if (map12 != null) {
                                    }
                                }
                                ModelAuditLogEntry.TargetType targetType9 = ModelAuditLogEntry.TargetType.THREAD;
                                if (map7.get(targetType9) == null) {
                                    map7.put(targetType9, new HashMap());
                                }
                                for (Channel channel2 : auditLogState.getThreads()) {
                                    Map map13 = (Map) map7.get(ModelAuditLogEntry.TargetType.THREAD);
                                    if (map13 != null) {
                                    }
                                }
                                boolean z2 = true;
                                ArrayList arrayList = new ArrayList(auditLogState.getEntries().size() + 1);
                                List<ModelAuditLogEntry> entries = auditLogState.getEntries();
                                ArrayList<ModelAuditLogEntry> arrayList2 = new ArrayList();
                                for (Object obj : entries) {
                                    if (AuditLogUtils.INSTANCE.getALL_ACTION_TYPES().contains(Integer.valueOf(((ModelAuditLogEntry) obj).getActionTypeId()))) {
                                        arrayList2.add(obj);
                                    }
                                }
                                for (ModelAuditLogEntry modelAuditLogEntry2 : arrayList2) {
                                    String str = ((modelAuditLogEntry2.getTargetType() == ModelAuditLogEntry.TargetType.CHANNEL || modelAuditLogEntry2.getTargetType() == ModelAuditLogEntry.TargetType.CHANNEL_OVERWRITE) && (channel = map6.get(Long.valueOf(modelAuditLogEntry2.getTargetId()))) != null && ChannelUtils.m7698v(channel) == z2) ? "#" : "";
                                    User user2 = auditLogState.getUsers().get(Long.valueOf(modelAuditLogEntry2.getUserId()));
                                    CharSequence charSequence = (user2 == null || (userNameWithDiscriminator$default = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user2, null, null, 3, null)) == null) ? "" : userNameWithDiscriminator$default;
                                    long id2 = modelAuditLogEntry2.getId();
                                    Long selectedItemId = auditLogState.getSelectedItemId();
                                    boolean z3 = selectedItemId != null && id2 == selectedItemId.longValue();
                                    User user3 = auditLogState.getUsers().get(Long.valueOf(modelAuditLogEntry2.getUserId()));
                                    GuildMember guildMember = map4.get(Long.valueOf(modelAuditLogEntry2.getUserId()));
                                    AuditLogUtils auditLogUtils = AuditLogUtils.INSTANCE;
                                    CharSequence headerString = auditLogUtils.getHeaderString(modelAuditLogEntry2, charSequence, context, map7, str);
                                    AuditLogChangeUtils auditLogChangeUtils = AuditLogChangeUtils.INSTANCE;
                                    arrayList.add(new WidgetServerSettingsAuditLogAdapter.AuditLogEntryItem(modelAuditLogEntry2, z3, user3, guildMember, headerString, auditLogChangeUtils.getChangeSummary(context, modelAuditLogEntry2, map7), auditLogChangeUtils.hasChangesToRender(modelAuditLogEntry2), auditLogUtils.getTimestampString(modelAuditLogEntry2, context)));
                                    z2 = true;
                                    map6 = map;
                                }
                                if (auditLogState.isLoading()) {
                                    arrayList.add(new WidgetServerSettingsAuditLogAdapter.AuditLogLoadingItem());
                                }
                                User user4 = map2.get(Long.valueOf(auditLogState.getFilter().getUserFilter()));
                                if (user4 == null || (string = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user4, null, null, 3, null)) == null) {
                                    string = context.getString(C5419R.string.guild_settings_filter_all_users);
                                    C12238m.checkNotNullExpressionValue(string, "context.getString(R.stri…ettings_filter_all_users)");
                                }
                                String string2 = context.getString(AuditLogUtils.INSTANCE.getActionName(auditLogState.getFilter().getActionFilter()));
                                C12238m.checkNotNullExpressionValue(string2, "context.getString(AuditL…ate.filter.actionFilter))");
                                return new WidgetServerSettingsAuditLog.Model.Loaded(arrayList, string, string2);
                            }
                            Map.Entry<Long, Channel> next = it.next();
                            String str2 = ChannelUtils.m7698v(next.getValue()) ? "#" : "";
                            Map map14 = (Map) map7.get(ModelAuditLogEntry.TargetType.CHANNEL);
                            if (map14 != null) {
                                Long lValueOf = Long.valueOf(next.getValue().getId());
                                StringBuilder sbM833U = C1643a.m833U(str2);
                                sbM833U.append(ChannelUtils.m7679c(next.getValue()));
                            }
                        }
                    }
                }).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
        public static final class Loaded extends Model {
            private final CharSequence actionFilterText;
            private final List<MGRecyclerDataPayload> auditLogEntryItems;
            private final CharSequence usernameFilterText;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends MGRecyclerDataPayload> list, CharSequence charSequence, CharSequence charSequence2) {
                super(null);
                C12238m.checkNotNullParameter(list, "auditLogEntryItems");
                C12238m.checkNotNullParameter(charSequence, "usernameFilterText");
                C12238m.checkNotNullParameter(charSequence2, "actionFilterText");
                this.auditLogEntryItems = list;
                this.usernameFilterText = charSequence;
                this.actionFilterText = charSequence2;
            }

            public final CharSequence getActionFilterText() {
                return this.actionFilterText;
            }

            public final List<MGRecyclerDataPayload> getAuditLogEntryItems() {
                return this.auditLogEntryItems;
            }

            public final CharSequence getUsernameFilterText() {
                return this.usernameFilterText;
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
        public static final class Loading extends Model {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
    public static final class C93231<T> implements Action1<Menu> {
        public C93231() {
        }

        @Override // p658rx.functions.Action1
        public final void call(Menu menu) {
            View actionView;
            MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_filter);
            if (menuItemFindItem == null || (actionView = menuItemFindItem.getActionView()) == null) {
                return;
            }
            actionView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog.onViewBound.1.1
                @Override // android.view.View.OnClickListener
                public final void onClick(final View view) {
                    PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(WidgetServerSettingsAuditLog.this.getContext(), 2131951663), view);
                    popupMenu.getMenuInflater().inflate(C5419R.menu.menu_audit_log_sort, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog.onViewBound.1.1.1
                        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            C12238m.checkNotNullExpressionValue(menuItem, "it");
                            switch (menuItem.getItemId()) {
                                case C5419R.id.menu_audit_log_sort_actions /* 2131364361 */:
                                    WidgetServerSettingsAuditLogFilter.INSTANCE.show(C1643a.m885x(view, "view", "view.context"), WidgetServerSettingsAuditLog.this.guildId, 1);
                                    return true;
                                case C5419R.id.menu_audit_log_sort_users /* 2131364362 */:
                                    WidgetServerSettingsAuditLogFilter.INSTANCE.show(C1643a.m885x(view, "view", "view.context"), WidgetServerSettingsAuditLog.this.guildId, 0);
                                    return true;
                                default:
                                    return true;
                            }
                        }
                    });
                    popupMenu.show();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
    public static final /* synthetic */ class C93271 extends C12236k implements Function1<Model, Unit> {
        public C93271(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog) {
            super(1, widgetServerSettingsAuditLog, WidgetServerSettingsAuditLog.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "p1");
            ((WidgetServerSettingsAuditLog) this.receiver).configureUI(model);
        }
    }

    public WidgetServerSettingsAuditLog() {
        super(C5419R.layout.widget_server_settings_audit_log);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsAuditLog$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsAuditLog$loggingConfig$1.INSTANCE, 3);
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f17510e;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsAuditLogsViewFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (model instanceof Model.Loaded) {
            WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter = this.adapter;
            if (widgetServerSettingsAuditLogAdapter != null) {
                widgetServerSettingsAuditLogAdapter.configure(((Model.Loaded) model).getAuditLogEntryItems());
            }
            AppViewFlipper appViewFlipper2 = getBinding().f17510e;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsAuditLogsViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            TextView textView = getBinding().f17509d;
            C12238m.checkNotNullExpressionValue(textView, "binding.serverSettingsAuditLogsUserFilter");
            Model.Loaded loaded = (Model.Loaded) model;
            textView.setText(loaded.getUsernameFilterText());
            TextView textView2 = getBinding().f17507b;
            C12238m.checkNotNullExpressionValue(textView2, "binding.serverSettingsAuditLogsActionFilter");
            textView2.setText(loaded.getActionFilterText());
            if (!loaded.getAuditLogEntryItems().isEmpty()) {
                AppViewFlipper appViewFlipper3 = getBinding().f17511f;
                C12238m.checkNotNullExpressionValue(appViewFlipper3, "binding.serverSettingsAuditLogsViewResultsFlipper");
                appViewFlipper3.setDisplayedChild(0);
            } else {
                AppViewFlipper appViewFlipper4 = getBinding().f17511f;
                C12238m.checkNotNullExpressionValue(appViewFlipper4, "binding.serverSettingsAuditLogsViewResultsFlipper");
                appViewFlipper4.setDisplayedChild(1);
            }
            this.loadingAuditLogs = false;
        }
    }

    public static final void create(Context context, long j, String str) {
        INSTANCE.create(context, j, str);
    }

    private final WidgetServerSettingsAuditLogBinding getBinding() {
        return (WidgetServerSettingsAuditLogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        FragmentActivity fragmentActivityM95e = m95e();
        if (fragmentActivityM95e != null && fragmentActivityM95e.isFinishing()) {
            StoreStream.INSTANCE.getAuditLog().clearState();
        }
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        long longExtra = getMostRecentIntent().getLongExtra(INTENT_EXTRA_GUILD_ID, -1L);
        this.guildId = longExtra;
        if (longExtra == -1) {
            C0876m.m169g(getContext(), C5419R.string.crash_unexpected, 0, null, 12);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
        setActionBarTitle(C5419R.string.guild_settings_label_audit_log);
        setActionBarSubtitle(getMostRecentIntent().getStringExtra(INTENT_EXTRA_GUILD_NAME));
        setActionBarOptionsMenu(C5419R.menu.menu_filter, null, new C93231());
        getBinding().f17508c.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog.onViewBound.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                C12238m.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (recyclerView.canScrollVertically(1)) {
                    return;
                }
                StoreStream.INSTANCE.getAuditLog().fetchMoreAuditLogEntries();
            }
        });
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17508c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsAuditLogsRecycler");
        WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter = (WidgetServerSettingsAuditLogAdapter) companion.configure(new WidgetServerSettingsAuditLogAdapter(recyclerView));
        widgetServerSettingsAuditLogAdapter.setOnAuditLogAvatarClicked(new WidgetServerSettingsAuditLog$onViewBound$$inlined$apply$lambda$1(this));
        this.adapter = widgetServerSettingsAuditLogAdapter;
        getBinding().f17509d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetServerSettingsAuditLogFilter.INSTANCE.show(C1643a.m885x(view2, "it", "it.context"), WidgetServerSettingsAuditLog.this.guildId, 0);
            }
        });
        getBinding().f17507b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog.onViewBound.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetServerSettingsAuditLogFilter.INSTANCE.show(C1643a.m885x(view2, "it", "it.context"), WidgetServerSettingsAuditLog.this.guildId, 1);
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(Model.INSTANCE.get(this.guildId, requireContext())), this, null, 2, null), (Class<?>) WidgetServerSettingsAuditLog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C93271(this));
    }
}
