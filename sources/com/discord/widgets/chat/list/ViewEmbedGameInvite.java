package com.discord.widgets.chat.list;

import a0.a.a.b;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivityParty;
import com.discord.api.application.Application;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.app.AppLog;
import com.discord.databinding.ViewChatEmbedGameInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.WidgetCollapsedUsersListAdapter;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.discord.widgets.chat.list.entries.GameInviteEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.d0._Ranges;
import d0.g0.StringNumberConversions;
import d0.t.Iterators5;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func5;
import rx.functions.Func6;

/* JADX INFO: compiled from: ViewEmbedGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewEmbedGameInvite extends LinearLayout {
    private static final long EMBED_LIFETIME_MILLIS = 7200000;
    private static final long MAX_USERS_SHOWN = 4;
    private final ViewChatEmbedGameInviteBinding binding;
    private Function2<? super View, ? super Model, Unit> onActionButtonClick;
    private final WidgetCollapsedUsersListAdapter userAdapter;

    /* JADX INFO: compiled from: ViewEmbedGameInvite.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Activity activity;
        private final Application application;
        private final boolean canJoin;
        private final long creationTime;
        private final long creatorId;
        private final List<String> gPlayPackageNames;
        private final boolean isInParty;
        private final boolean isPartyMatch;
        private final MeUser meUser;
        private final MessageActivity messageActivity;
        private final List<CollapsedUser> users;

        /* JADX INFO: compiled from: ViewEmbedGameInvite.kt */
        public static final class Companion {
            private Companion() {
            }

            private final Model create(GameInviteEntry item, MeUser meUser, Application application, Activity gameActivity, Map<Long, ? extends User> userMap) {
                return new Model(meUser, item.getAuthorId(), SnowflakeUtils.DISCORD_EPOCH + (item.getMessageId() >>> 22), application != null ? application : item.getApplication(), item.getActivity(), gameActivity, createPartyUsers(userMap, gameActivity));
            }

            private final Model createForShare(MeUser meUser, long creationTime, MessageActivity msgActivity, Activity gameActivity, Map<Long, ? extends User> userMap, Application application) {
                if (application != null) {
                    return new Model(meUser, meUser.getId(), creationTime, application, msgActivity, gameActivity, createPartyUsers(userMap, gameActivity));
                }
                return null;
            }

            private final ArrayList<CollapsedUser> createPartyUsers(Map<Long, ? extends User> userMap, Activity gameActivity) {
                ActivityParty party;
                ArrayList<CollapsedUser> arrayList = new ArrayList<>();
                Iterator<T> it = userMap.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(new CollapsedUser((User) it.next(), false, 0L, 6, null));
                }
                long maxSize = (gameActivity == null || (party = gameActivity.getParty()) == null) ? 0L : PresenceUtils.INSTANCE.getMaxSize(party);
                Iterator<Long> it2 = _Ranges.until(userMap.size(), Math.min(4L, maxSize)).iterator();
                while (it2.hasNext()) {
                    arrayList.add(CollapsedUser.INSTANCE.createEmptyUser(((Iterators5) it2).nextLong() == 3 ? maxSize - 4 : 0L));
                }
                return arrayList;
            }

            public final Observable<Model> get(GameInviteEntry item) {
                Intrinsics3.checkNotNullParameter(item, "item");
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(item);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
                Observable<Application> observableObserveApplication = companion.getApplication().observeApplication(Long.valueOf(item.getApplication().getId()));
                Observable<Activity> observableObserveApplicationActivity = companion.getPresences().observeApplicationActivity(item.getAuthorId(), item.getApplication().getId());
                Observable<Map<Long, User>> observableObserveUsersForPartyId = companion.getGameParty().observeUsersForPartyId(item.getActivity().getPartyId());
                final ViewEmbedGameInvite2 viewEmbedGameInvite2 = new ViewEmbedGameInvite2(this);
                Observable observableG = Observable.g(scalarSynchronousObservable, observableObserveMe$default, observableObserveApplication, observableObserveApplicationActivity, observableObserveUsersForPartyId, new Func5() { // from class: com.discord.widgets.chat.list.ViewEmbedGameInvite$sam$rx_functions_Func5$0
                    @Override // rx.functions.Func5
                    public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                        return viewEmbedGameInvite2.invoke(obj, obj2, obj3, obj4, obj5);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableG, "Observable\n            .…   ::create\n            )");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
                return observableR;
            }

            public final Observable<Model> getForShare(Clock clock, Uri shareUri, Activity activity) {
                Intrinsics3.checkNotNullParameter(clock, "clock");
                if (shareUri == null) {
                    ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(null)");
                    return scalarSynchronousObservable;
                }
                String queryParameter = shareUri.getQueryParameter(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID);
                final Long longOrNull = queryParameter != null ? StringNumberConversions.toLongOrNull(queryParameter) : null;
                final String queryParameter2 = shareUri.getQueryParameter("party_id");
                String queryParameter3 = shareUri.getQueryParameter("type");
                Integer intOrNull = queryParameter3 != null ? StringNumberConversions.toIntOrNull(queryParameter3) : null;
                if (longOrNull == null || queryParameter2 == null || intOrNull == null || (!Intrinsics3.areEqual(shareUri.getPath(), "/send/activity"))) {
                    Logger.w$default(AppLog.g, "Malformed Share URI: " + shareUri, null, 2, null);
                    ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(null);
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "Observable.just(null)");
                    return scalarSynchronousObservable2;
                }
                MessageActivity messageActivity = new MessageActivity(MessageActivityType.INSTANCE.a(intOrNull), queryParameter2);
                ScalarSynchronousObservable scalarSynchronousObservable3 = new ScalarSynchronousObservable(activity);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM = Observable.m(scalarSynchronousObservable3, companion.getUsers().observeMeId().Y(new Func1<Long, Observable<? extends Activity>>() { // from class: com.discord.widgets.chat.list.ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1
                    @Override // j0.k.Func1
                    public final Observable<? extends Activity> call(Long l) {
                        StoreUserPresence presences = StoreStream.INSTANCE.getPresences();
                        Intrinsics3.checkNotNullExpressionValue(l, "authorId");
                        return presences.observeApplicationActivity(l.longValue(), longOrNull.longValue()).y(new Func1<Activity, Boolean>() { // from class: com.discord.widgets.chat.list.ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1.1
                            /* JADX WARN: Code duplicated, block: B:10:0x001a  */
                            @Override // j0.k.Func1
                            public final Boolean call(Activity activity2) {
                                boolean z2;
                                if (activity2 == null) {
                                    z2 = false;
                                } else {
                                    ActivityParty party = activity2.getParty();
                                    if (Intrinsics3.areEqual(party != null ? party.getId() : null, queryParameter2)) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                }
                                return Boolean.valueOf(z2);
                            }
                        });
                    }
                }));
                Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
                ScalarSynchronousObservable scalarSynchronousObservable4 = new ScalarSynchronousObservable(Long.valueOf(clock.currentTimeMillis()));
                ScalarSynchronousObservable scalarSynchronousObservable5 = new ScalarSynchronousObservable(messageActivity);
                Observable<Map<Long, User>> observableObserveUsersForPartyId = companion.getGameParty().observeUsersForPartyId(messageActivity.getPartyId());
                Observable<Application> observableObserveApplication = companion.getApplication().observeApplication(longOrNull);
                final ViewEmbedGameInvite3 viewEmbedGameInvite3 = new ViewEmbedGameInvite3(this);
                Observable observableF = Observable.f(observableObserveMe$default, scalarSynchronousObservable4, scalarSynchronousObservable5, observableM, observableObserveUsersForPartyId, observableObserveApplication, new Func6() { // from class: com.discord.widgets.chat.list.ViewEmbedGameInvite$sam$rx_functions_Func6$0
                    @Override // rx.functions.Func6
                    public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                        return viewEmbedGameInvite3.invoke(obj, obj2, obj3, obj4, obj5, obj6);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableF, "Observable\n            .…ateForShare\n            )");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableF).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, long j, long j2, Application application, MessageActivity messageActivity, Activity activity, List<CollapsedUser> list) {
            boolean z2;
            ActivityParty party;
            String id2;
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(application, "application");
            Intrinsics3.checkNotNullParameter(messageActivity, "messageActivity");
            Intrinsics3.checkNotNullParameter(list, "users");
            this.meUser = meUser;
            this.creatorId = j;
            this.creationTime = j2;
            this.application = application;
            this.messageActivity = messageActivity;
            this.activity = activity;
            this.users = list;
            boolean zEquals = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    } else {
                        if (((CollapsedUser) it.next()).getUser().getId() == this.meUser.getId()) {
                            z2 = true;
                            break;
                        }
                    }
                }
            } else {
                z2 = false;
                break;
            }
            this.isInParty = z2;
            Activity activity2 = this.activity;
            this.canJoin = activity2 != null && ActivityUtils.hasFlag(activity2, 2) && ActivityUtils.isCurrentPlatform(this.activity);
            this.gPlayPackageNames = this.application.d();
            Activity activity3 = this.activity;
            if (activity3 != null && (party = activity3.getParty()) != null && (id2 = party.getId()) != null) {
                zEquals = id2.equals(getPartyId());
            }
            this.isPartyMatch = zEquals;
        }

        private final String getPartyId() {
            return this.messageActivity.getPartyId();
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getCreatorId() {
            return this.creatorId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getCreationTime() {
            return this.creationTime;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Application getApplication() {
            return this.application;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final MessageActivity getMessageActivity() {
            return this.messageActivity;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Activity getActivity() {
            return this.activity;
        }

        public final List<CollapsedUser> component7() {
            return this.users;
        }

        public final Model copy(MeUser meUser, long creatorId, long creationTime, Application application, MessageActivity messageActivity, Activity activity, List<CollapsedUser> users) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(application, "application");
            Intrinsics3.checkNotNullParameter(messageActivity, "messageActivity");
            Intrinsics3.checkNotNullParameter(users, "users");
            return new Model(meUser, creatorId, creationTime, application, messageActivity, activity, users);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.meUser, model.meUser) && this.creatorId == model.creatorId && this.creationTime == model.creationTime && Intrinsics3.areEqual(this.application, model.application) && Intrinsics3.areEqual(this.messageActivity, model.messageActivity) && Intrinsics3.areEqual(this.activity, model.activity) && Intrinsics3.areEqual(this.users, model.users);
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final Application getApplication() {
            return this.application;
        }

        public final boolean getCanJoin() {
            return this.canJoin;
        }

        public final long getCreationTime() {
            return this.creationTime;
        }

        public final long getCreatorId() {
            return this.creatorId;
        }

        public final List<String> getGPlayPackageNames() {
            return this.gPlayPackageNames;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final MessageActivity getMessageActivity() {
            return this.messageActivity;
        }

        public final List<CollapsedUser> getUsers() {
            return this.users;
        }

        public int hashCode() {
            MeUser meUser = this.meUser;
            int iA = (b.a(this.creationTime) + ((b.a(this.creatorId) + ((meUser != null ? meUser.hashCode() : 0) * 31)) * 31)) * 31;
            Application application = this.application;
            int iHashCode = (iA + (application != null ? application.hashCode() : 0)) * 31;
            MessageActivity messageActivity = this.messageActivity;
            int iHashCode2 = (iHashCode + (messageActivity != null ? messageActivity.hashCode() : 0)) * 31;
            Activity activity = this.activity;
            int iHashCode3 = (iHashCode2 + (activity != null ? activity.hashCode() : 0)) * 31;
            List<CollapsedUser> list = this.users;
            return iHashCode3 + (list != null ? list.hashCode() : 0);
        }

        public final boolean isDeadInvite(long now) {
            return !this.isPartyMatch || isExpiredInvite(now);
        }

        public final boolean isExpiredInvite(long now) {
            return now > this.creationTime + ViewEmbedGameInvite.EMBED_LIFETIME_MILLIS;
        }

        /* JADX INFO: renamed from: isInParty, reason: from getter */
        public final boolean getIsInParty() {
            return this.isInParty;
        }

        /* JADX INFO: renamed from: isPartyMatch, reason: from getter */
        public final boolean getIsPartyMatch() {
            return this.isPartyMatch;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(meUser=");
            sbU.append(this.meUser);
            sbU.append(", creatorId=");
            sbU.append(this.creatorId);
            sbU.append(", creationTime=");
            sbU.append(this.creationTime);
            sbU.append(", application=");
            sbU.append(this.application);
            sbU.append(", messageActivity=");
            sbU.append(this.messageActivity);
            sbU.append(", activity=");
            sbU.append(this.activity);
            sbU.append(", users=");
            return outline.L(sbU, this.users, ")");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewEmbedGameInvite(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewChatEmbedGameInviteBinding viewChatEmbedGameInviteBindingA = ViewChatEmbedGameInviteBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewChatEmbedGameInviteBindingA, "ViewChatEmbedGameInviteB…ater.from(context), this)");
        this.binding = viewChatEmbedGameInviteBindingA;
        setOrientation(1);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = viewChatEmbedGameInviteBindingA.h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        this.userAdapter = (WidgetCollapsedUsersListAdapter) companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }

    private final void configureActivityImages(Model model, boolean z2) {
        String smallImage;
        SimpleDraweeView simpleDraweeView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemGameInviteAvatarIv");
        String icon = model.getApplication().getIcon();
        MGImages.setImage$default(simpleDraweeView, icon != null ? IconUtils.getApplicationIcon$default(model.getApplication().getId(), icon, 0, 4, (Object) null) : null, 0, 0, false, null, null, 124, null);
        Activity activity = model.getActivity();
        ActivityAssets assets = activity != null ? activity.getAssets() : null;
        SimpleDraweeView simpleDraweeView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemGameInviteAvatarStatusIv");
        simpleDraweeView2.setVisibility((assets != null ? assets.getSmallImage() : null) != null ? 0 : 8);
        SimpleDraweeView simpleDraweeView3 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemGameInviteAvatarStatusIv");
        MGImages.setImage$default(simpleDraweeView3, (assets == null || (smallImage = assets.getSmallImage()) == null) ? null : IconUtils.getAssetImage$default(IconUtils.INSTANCE, Long.valueOf(model.getApplication().getId()), smallImage, 0, 4, null), 0, 0, false, null, null, 124, null);
        SimpleDraweeView simpleDraweeView4 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.itemGameInviteAvatarStatusIv");
        simpleDraweeView4.setContentDescription(assets != null ? assets.getSmallText() : null);
        if (z2) {
            SimpleDraweeView simpleDraweeView5 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView5, "binding.itemGameInviteCoverIv");
            simpleDraweeView5.setVisibility(8);
            SimpleDraweeView simpleDraweeView6 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView6, "binding.itemGameInviteCoverIv");
            MGImages.setImage$default(simpleDraweeView6, null, 0, 0, false, null, null, 124, null);
            return;
        }
        SimpleDraweeView simpleDraweeView7 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView7, "binding.itemGameInviteCoverIv");
        simpleDraweeView7.setVisibility(0);
        String largeImage = assets != null ? assets.getLargeImage() : null;
        if (largeImage != null) {
            SimpleDraweeView simpleDraweeView8 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView8, "binding.itemGameInviteCoverIv");
            simpleDraweeView8.setContentDescription(assets.getLargeText());
            SimpleDraweeView simpleDraweeView9 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView9, "binding.itemGameInviteCoverIv");
            simpleDraweeView9.setImportantForAccessibility(1);
            String assetImage = IconUtils.INSTANCE.getAssetImage(Long.valueOf(model.getApplication().getId()), largeImage, IconUtils.getMediaProxySize(getWidth()));
            SimpleDraweeView simpleDraweeView10 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView10, "binding.itemGameInviteCoverIv");
            MGImages.setImage$default(simpleDraweeView10, assetImage, 0, 0, false, null, null, 124, null);
            return;
        }
        SimpleDraweeView simpleDraweeView11 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView11, "binding.itemGameInviteCoverIv");
        simpleDraweeView11.setImportantForAccessibility(2);
        SimpleDraweeView simpleDraweeView12 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView12, "binding.itemGameInviteCoverIv");
        simpleDraweeView12.setContentDescription(null);
        String coverImage = model.getApplication().getCoverImage();
        String applicationIcon$default = coverImage != null ? IconUtils.getApplicationIcon$default(model.getApplication().getId(), coverImage, 0, 4, (Object) null) : null;
        SimpleDraweeView simpleDraweeView13 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView13, "binding.itemGameInviteCoverIv");
        MGImages.setImage$default(simpleDraweeView13, applicationIcon$default, 0, 0, false, null, null, 124, null);
    }

    private final void configureUI(Model model, Clock clock) {
        Activity activity;
        ActivityParty party;
        boolean zIsDeadInvite = model.isDeadInvite(clock.currentTimeMillis());
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGameInviteApplicationNameTv");
        textView.setText(model.getApplication().getName());
        TextView textView2 = this.binding.g;
        int i = R.string.invite_embed_game_has_ended;
        if (!zIsDeadInvite && model.getMessageActivity().getType() != MessageActivityType.SPECTATE) {
            i = R.string.invite_embed_invite_to_join_group;
        }
        textView2.setText(i);
        boolean z2 = ((!zIsDeadInvite && (activity = model.getActivity()) != null && (party = activity.getParty()) != null) ? PresenceUtils.INSTANCE.getNumOpenSlots(party) : 0L) <= 0;
        TextView textView3 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemGameInviteSubtext");
        String state = null;
        if (z2) {
            Activity activity2 = model.getActivity();
            if (activity2 != null) {
                state = activity2.getDetails();
            }
        } else {
            Activity activity3 = model.getActivity();
            if (activity3 != null) {
                state = activity3.getState();
            }
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, state);
        configureActivityImages(model, zIsDeadInvite);
        onConfigureActionButton(model, zIsDeadInvite, z2);
        RecyclerView recyclerView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        recyclerView.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        if (zIsDeadInvite) {
            return;
        }
        this.userAdapter.setData(model.getUsers());
    }

    private final void onConfigureActionButton(final Model model, boolean z2, boolean z3) {
        MaterialButton materialButton = this.binding.f2177b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGameInviteActionBtn");
        boolean z4 = false;
        materialButton.setVisibility(0);
        int i = R.string.join;
        if (z2 || !model.getCanJoin()) {
            MaterialButton materialButton2 = this.binding.f2177b;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemGameInviteActionBtn");
            materialButton2.setEnabled(false);
            this.binding.f2177b.setText(R.string.join);
            return;
        }
        MaterialButton materialButton3 = this.binding.f2177b;
        Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.itemGameInviteActionBtn");
        if (!model.getIsInParty() && !z3 && model.getCreatorId() != model.getMeUser().getId()) {
            z4 = true;
        }
        materialButton3.setEnabled(z4);
        MaterialButton materialButton4 = this.binding.f2177b;
        if (z3) {
            i = R.string.invite_embed_full_group;
        } else if (model.getIsInParty()) {
            i = R.string.invite_embed_joined;
        }
        materialButton4.setText(i);
        this.binding.f2177b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.ViewEmbedGameInvite.onConfigureActionButton.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function2<View, Model, Unit> onActionButtonClick = ViewEmbedGameInvite.this.getOnActionButtonClick();
                if (onActionButtonClick != null) {
                    Intrinsics3.checkNotNullExpressionValue(view, "it");
                    onActionButtonClick.invoke(view, model);
                }
            }
        });
    }

    public final void bind(Model model, Clock clock) {
        Intrinsics3.checkNotNullParameter(model, "model");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        configureUI(model, clock);
    }

    public final Function2<View, Model, Unit> getOnActionButtonClick() {
        return this.onActionButtonClick;
    }

    public final void setOnActionButtonClick(Function2<? super View, ? super Model, Unit> function2) {
        this.onActionButtonClick = function2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewEmbedGameInvite(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewChatEmbedGameInviteBinding viewChatEmbedGameInviteBindingA = ViewChatEmbedGameInviteBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewChatEmbedGameInviteBindingA, "ViewChatEmbedGameInviteB…ater.from(context), this)");
        this.binding = viewChatEmbedGameInviteBindingA;
        setOrientation(1);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = viewChatEmbedGameInviteBindingA.h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        this.userAdapter = (WidgetCollapsedUsersListAdapter) companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewEmbedGameInvite(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewChatEmbedGameInviteBinding viewChatEmbedGameInviteBindingA = ViewChatEmbedGameInviteBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewChatEmbedGameInviteBindingA, "ViewChatEmbedGameInviteB…ater.from(context), this)");
        this.binding = viewChatEmbedGameInviteBindingA;
        setOrientation(1);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = viewChatEmbedGameInviteBindingA.h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        this.userAdapter = (WidgetCollapsedUsersListAdapter) companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewEmbedGameInvite(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewChatEmbedGameInviteBinding viewChatEmbedGameInviteBindingA = ViewChatEmbedGameInviteBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewChatEmbedGameInviteBindingA, "ViewChatEmbedGameInviteB…ater.from(context), this)");
        this.binding = viewChatEmbedGameInviteBindingA;
        setOrientation(1);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = viewChatEmbedGameInviteBindingA.h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        this.userAdapter = (WidgetCollapsedUsersListAdapter) companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }
}
