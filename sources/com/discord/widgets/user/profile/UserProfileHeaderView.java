package com.discord.widgets.user.profile;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$integer;
import com.discord.R$layout;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.user.UserProfile;
import com.discord.app.AppLog;
import com.discord.databinding.UserProfileHeaderViewBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.colors.RepresentativeColorsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$DistinctChangeDetector;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.EmojiNode$Companion;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.utilities.viewcontroller.ViewDetachedFromWindowObservable;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.UsernameView;
import com.discord.views.user.UserAvatarPresenceView;
import com.discord.views.user.UserAvatarPresenceView$a;
import com.discord.widgets.channels.UserAkaView;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.Badge$Companion;
import com.discord.widgets.user.UserNameFormatterKt;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.t;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView extends ConstraintLayout {
    public static final UserProfileHeaderView$Companion Companion = new UserProfileHeaderView$Companion(null);
    private final SimpleRecyclerAdapter<Badge, UserProfileHeaderView$BadgeViewHolder> badgesAdapter;
    private MGImages$DistinctChangeDetector bannerChangeDetector;
    private final UserProfileHeaderViewBinding binding;
    private Function0<Unit> onAvatarEdit;
    private Function1<? super Integer, Unit> onAvatarRepresentativeColorUpdated;
    private Function1<? super Badge, Unit> onBadgeClick;
    private Function0<Unit> onBannerPress;
    private Subscription setBannerBackgroundColorSubscription;
    private Subscription syncAvatarRepresentativeColorSubscription;
    private int userProfileHeaderBackgroundColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.user_profile_header_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.avatar_edit;
        CardView cardView = (CardView) viewInflate.findViewById(R$id.avatar_edit);
        if (cardView != null) {
            i = R$id.banner;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R$id.banner);
            if (simpleDraweeView != null) {
                i = R$id.banner_edit;
                CardView cardView2 = (CardView) viewInflate.findViewById(R$id.banner_edit);
                if (cardView2 != null) {
                    i = R$id.gif_tag;
                    ImageView imageView = (ImageView) viewInflate.findViewById(R$id.gif_tag);
                    if (imageView != null) {
                        i = R$id.large_avatar;
                        UserAvatarPresenceView userAvatarPresenceView = (UserAvatarPresenceView) viewInflate.findViewById(R$id.large_avatar);
                        if (userAvatarPresenceView != null) {
                            i = R$id.large_avatar_barrier;
                            Barrier barrier = (Barrier) viewInflate.findViewById(R$id.large_avatar_barrier);
                            if (barrier != null) {
                                i = R$id.user_aka;
                                UserAkaView userAkaView = (UserAkaView) viewInflate.findViewById(R$id.user_aka);
                                if (userAkaView != null) {
                                    i = R$id.user_profile_header_badges_recycler;
                                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.user_profile_header_badges_recycler);
                                    if (recyclerView != null) {
                                        i = R$id.user_profile_header_custom_status;
                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) viewInflate.findViewById(R$id.user_profile_header_custom_status);
                                        if (simpleDraweeSpanTextView != null) {
                                            i = R$id.user_profile_header_name_wrap;
                                            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.user_profile_header_name_wrap);
                                            if (linearLayout != null) {
                                                i = R$id.user_profile_header_primary_name;
                                                UsernameView usernameView = (UsernameView) viewInflate.findViewById(R$id.user_profile_header_primary_name);
                                                if (usernameView != null) {
                                                    i = R$id.user_profile_header_secondary_name;
                                                    SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = (SimpleDraweeSpanTextView) viewInflate.findViewById(R$id.user_profile_header_secondary_name);
                                                    if (simpleDraweeSpanTextView2 != null) {
                                                        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                                                        UserProfileHeaderViewBinding userProfileHeaderViewBinding = new UserProfileHeaderViewBinding(constraintLayout, cardView, simpleDraweeView, cardView2, imageView, userAvatarPresenceView, barrier, userAkaView, recyclerView, simpleDraweeSpanTextView, linearLayout, usernameView, simpleDraweeSpanTextView2, constraintLayout);
                                                        m.checkNotNullExpressionValue(userProfileHeaderViewBinding, "UserProfileHeaderViewBin…rom(context), this, true)");
                                                        this.binding = userProfileHeaderViewBinding;
                                                        this.bannerChangeDetector = new MGImages$DistinctChangeDetector();
                                                        this.onBadgeClick = UserProfileHeaderView$onBadgeClick$1.INSTANCE;
                                                        this.onAvatarEdit = UserProfileHeaderView$onAvatarEdit$1.INSTANCE;
                                                        this.onBannerPress = UserProfileHeaderView$onBannerPress$1.INSTANCE;
                                                        this.onAvatarRepresentativeColorUpdated = UserProfileHeaderView$onAvatarRepresentativeColorUpdated$1.INSTANCE;
                                                        RightToLeftGridLayoutManager rightToLeftGridLayoutManager = new RightToLeftGridLayoutManager(context, 3, 1, true);
                                                        m.checkNotNullExpressionValue(recyclerView, "binding.userProfileHeaderBadgesRecycler");
                                                        recyclerView.setLayoutManager(rightToLeftGridLayoutManager);
                                                        SimpleRecyclerAdapter<Badge, UserProfileHeaderView$BadgeViewHolder> simpleRecyclerAdapter = new SimpleRecyclerAdapter<>(null, new UserProfileHeaderView$1(this), 1, null);
                                                        this.badgesAdapter = simpleRecyclerAdapter;
                                                        m.checkNotNullExpressionValue(recyclerView, "binding.userProfileHeaderBadgesRecycler");
                                                        recyclerView.setAdapter(simpleRecyclerAdapter);
                                                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$a.UserProfileHeaderView);
                                                        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.UserProfileHeaderView)");
                                                        this.userProfileHeaderBackgroundColor = typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getThemedColor(this, 2130969997));
                                                        typedArrayObtainStyledAttributes.recycle();
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$editAvatar(UserProfileHeaderView userProfileHeaderView, UserProfileHeaderViewModel$ViewState$Loaded userProfileHeaderViewModel$ViewState$Loaded) {
        userProfileHeaderView.editAvatar(userProfileHeaderViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ UserProfileHeaderViewBinding access$getBinding$p(UserProfileHeaderView userProfileHeaderView) {
        return userProfileHeaderView.binding;
    }

    public static final /* synthetic */ Subscription access$getSetBannerBackgroundColorSubscription$p(UserProfileHeaderView userProfileHeaderView) {
        return userProfileHeaderView.setBannerBackgroundColorSubscription;
    }

    public static final /* synthetic */ Subscription access$getSyncAvatarRepresentativeColorSubscription$p(UserProfileHeaderView userProfileHeaderView) {
        return userProfileHeaderView.syncAvatarRepresentativeColorSubscription;
    }

    public static final /* synthetic */ void access$onTapBanner(UserProfileHeaderView userProfileHeaderView) {
        userProfileHeaderView.onTapBanner();
    }

    public static final /* synthetic */ void access$setSetBannerBackgroundColorSubscription$p(UserProfileHeaderView userProfileHeaderView, Subscription subscription) {
        userProfileHeaderView.setBannerBackgroundColorSubscription = subscription;
    }

    public static final /* synthetic */ void access$setSyncAvatarRepresentativeColorSubscription$p(UserProfileHeaderView userProfileHeaderView, Subscription subscription) {
        userProfileHeaderView.syncAvatarRepresentativeColorSubscription = subscription;
    }

    private final void configureAka(UserProfileHeaderViewModel$ViewState$Loaded viewState) {
        UserAkaView userAkaView = this.binding.g;
        m.checkNotNullExpressionValue(userAkaView, "binding.userAka");
        userAkaView.setVisibility(viewState.getShowAkas() ? 0 : 8);
        this.binding.g.configure(viewState.getGuildMembersForAka());
    }

    private final void configureBanner(UserProfileHeaderViewModel$ViewState$Loaded viewState) {
        String banner;
        String forUserBanner;
        String str;
        GuildMember guildMember = viewState.getGuildMember();
        if (guildMember == null || (banner = guildMember.getBannerHash()) == null) {
            banner = viewState.getBanner();
        }
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        int i = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        int iMax = Math.max(i, resources2.getDisplayMetrics().heightPixels);
        if (banner == null || !t.startsWith$default(banner, "data:", false, 2, null)) {
            GuildMember guildMember2 = viewState.getGuildMember();
            if (guildMember2 == null || !guildMember2.hasBanner()) {
                forUserBanner = IconUtils.INSTANCE.getForUserBanner(viewState.getUser().getId(), banner, Integer.valueOf(iMax), viewState.getShouldAnimateBanner());
            } else {
                IconUtils iconUtils = IconUtils.INSTANCE;
                GuildMember guildMember3 = viewState.getGuildMember();
                forUserBanner = iconUtils.getForGuildMemberBanner(banner, (guildMember3 != null ? Long.valueOf(guildMember3.getGuildId()) : null).longValue(), viewState.getUser().getId(), Integer.valueOf(iMax), viewState.getShouldAnimateBanner());
            }
            str = forUserBanner;
        } else {
            str = banner;
        }
        boolean z2 = !(str == null || t.isBlank(str));
        boolean z3 = (banner != null && IconUtils.INSTANCE.isDataUrlForGif(banner)) || (banner != null && !t.startsWith$default(banner, "data:", false, 2, null) && IconUtils.INSTANCE.isImageHashAnimated(banner));
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.banner");
        simpleDraweeView.setAspectRatio(!z2 ? 5.0f : 2.5f);
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = false;
        notifyAvatarColorListenerAsync(viewState);
        if ((!z2 || z3) && viewState.getIsProfileLoaded()) {
            updateBannerColor(viewState);
            ref$BooleanRef.element = true;
        } else if (!viewState.getIsProfileLoaded()) {
            this.binding.c.setBackgroundColor(this.userProfileHeaderBackgroundColor);
        }
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.banner");
        MGImages.setImage$default(simpleDraweeView2, str, 0, 0, false, new UserProfileHeaderView$configureBanner$1(this, ref$BooleanRef, viewState), this.bannerChangeDetector, 28, null);
        this.binding.c.setOnClickListener(new UserProfileHeaderView$configureBanner$2(this));
        this.binding.d.setOnClickListener(new UserProfileHeaderView$configureBanner$3(this));
        ImageView imageView = this.binding.e;
        m.checkNotNullExpressionValue(imageView, "binding.gifTag");
        imageView.setVisibility(viewState.getShouldShowGIFTag() ? 0 : 8);
    }

    private final void configurePrimaryName(UserProfileHeaderViewModel$ViewState$Loaded viewState) {
        User user = viewState.getUser();
        GuildMember guildMember = viewState.getGuildMember();
        int dimension = (int) getResources().getDimension(2131165294);
        this.binding.j.b(getPrimaryNameTextForUser(user, guildMember), viewState.getShowMediumAvatar() ? IconUtils.getForUser(viewState.getUser(), false, Integer.valueOf(dimension)) : null, false, Integer.valueOf(dimension), Integer.valueOf(this.userProfileHeaderBackgroundColor));
        this.binding.j.a(user.getIsBot(), user.getIsSystemUser() ? 2131896165 : 2131887281, UserUtils.INSTANCE.isVerifiedBot(user));
    }

    private final void configureSecondaryName(UserProfileHeaderViewModel$ViewState$Loaded viewState) {
        User user = viewState.getUser();
        GuildMember guildMember = viewState.getGuildMember();
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        if (viewState.getShowSmallAvatar()) {
            int dimension = (int) getResources().getDimension(2131165295);
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            DraweeSpanStringBuilderExtensionsKt.setAvatar$default(draweeSpanStringBuilder, context, IconUtils.getForUser(viewState.getUser(), false, Integer.valueOf(dimension)), false, Integer.valueOf(dimension), Integer.valueOf(this.userProfileHeaderBackgroundColor), null, 32, null);
        }
        CharSequence secondaryNameTextForUser = getSecondaryNameTextForUser(user, guildMember);
        boolean z2 = ((secondaryNameTextForUser == null || t.isBlank(secondaryNameTextForUser)) || viewState.getShowAkas()) ? false : true;
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.k;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.userProfileHeaderSecondaryName");
        simpleDraweeSpanTextView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            draweeSpanStringBuilder.append(secondaryNameTextForUser);
            this.binding.k.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
        }
    }

    private final void editAvatar(UserProfileHeaderViewModel$ViewState$Loaded viewState) {
        if (viewState.getEditable()) {
            this.onAvatarEdit.invoke();
        }
    }

    private final DraweeSpanStringBuilder getCustomStatusDraweeSpanStringBuilder(Activity customStatusActivity, boolean shouldAnimate) {
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        ActivityEmoji emoji = customStatusActivity.getEmoji();
        EmojiNode emojiNodeFrom$default = null;
        if (emoji != null) {
            EmojiNode$Companion emojiNode$Companion = EmojiNode.Companion;
            emojiNodeFrom$default = EmojiNode$Companion.from$default(emojiNode$Companion, 0, emojiNode$Companion.generateEmojiIdAndType(emoji), 1, (Object) null);
        }
        if (emojiNodeFrom$default != null) {
            emojiNodeFrom$default.render((SpannableStringBuilder) draweeSpanStringBuilder, new UserProfileHeaderView$getCustomStatusDraweeSpanStringBuilder$1(this, shouldAnimate));
        }
        String state = customStatusActivity.getState();
        if (state != null) {
            if (emojiNodeFrom$default != null) {
                draweeSpanStringBuilder.append((char) 8194);
            }
            draweeSpanStringBuilder.append((CharSequence) state);
        }
        return draweeSpanStringBuilder;
    }

    private final SpannableStringBuilder getPrimaryNameTextForUser(User user, GuildMember guildMember) {
        String nick = guildMember != null ? guildMember.getNick() : null;
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        return UserNameFormatterKt.getSpannableForUserNameWithDiscrim(user, nick, context, 2130968989, 2130969390, R$integer.uikit_textsize_xxlarge_sp, 2130968990, 2130969396, R$integer.uikit_textsize_xxlarge_sp);
    }

    private final CharSequence getSecondaryNameTextForUser(User user, GuildMember guildMember) {
        if (guildMember == null || guildMember.getNick() == null) {
            return null;
        }
        return UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
    }

    private final void notifyAvatarColorListenerAsync(UserProfileHeaderViewModel$ViewState$Loaded viewState) {
        Subscription subscription = this.syncAvatarRepresentativeColorSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(observeRepresentativeColor(viewState), UserProfileHeaderView.class, (Context) null, new UserProfileHeaderView$notifyAvatarColorListenerAsync$1(this), (Function1) null, (Function0) null, (Function0) null, new UserProfileHeaderView$notifyAvatarColorListenerAsync$2(this), 58, (Object) null);
    }

    private final Observable<Integer> observeRepresentativeColor(UserProfileHeaderViewModel$ViewState$Loaded viewState) {
        GuildMember guildMember = viewState.getGuildMember();
        Observable<Integer> observableB0 = ObservableExtensionsKt.ui((guildMember == null || !guildMember.hasAvatar()) ? RepresentativeColorsKt.getUserRepresentativeColors().observeRepresentativeColor(viewState.getAvatarColorId()) : RepresentativeColorsKt.getGuildMemberRepresentativeColors().observeRepresentativeColor(viewState.getGuildMemberColorId())).a0(new ViewDetachedFromWindowObservable(this).observe()).b0(UserProfileHeaderView$observeRepresentativeColor$1.INSTANCE);
        m.checkNotNullExpressionValue(observableB0, "representativeColorObser….takeUntil { it != null }");
        return observableB0;
    }

    private final void onTapBanner() {
        this.onBannerPress.invoke();
    }

    private final void updateBannerBackgroundColorAsync(UserProfileHeaderViewModel$ViewState$Loaded viewState) {
        Subscription subscription = this.setBannerBackgroundColorSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(observeRepresentativeColor(viewState), UserProfileHeaderView.class, (Context) null, new UserProfileHeaderView$updateBannerBackgroundColorAsync$1(this), (Function1) null, (Function0) null, (Function0) null, new UserProfileHeaderView$updateBannerBackgroundColorAsync$2(this), 58, (Object) null);
    }

    public final Function0<Unit> getOnAvatarEdit() {
        return this.onAvatarEdit;
    }

    public final Function1<Integer, Unit> getOnAvatarRepresentativeColorUpdated() {
        return this.onAvatarRepresentativeColorUpdated;
    }

    public final Function1<Badge, Unit> getOnBadgeClick() {
        return this.onBadgeClick;
    }

    public final Function0<Unit> getOnBannerPress() {
        return this.onBannerPress;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.userProfileHeaderBackgroundColor;
        if (i != 0) {
            setBackgroundColor(i);
            this.binding.f.setAvatarBackgroundColor(this.userProfileHeaderBackgroundColor);
            this.binding.c.setBackgroundColor(this.userProfileHeaderBackgroundColor);
        }
    }

    public final void setOnAvatarEdit(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onAvatarEdit = function0;
    }

    public final void setOnAvatarRepresentativeColorUpdated(Function1<? super Integer, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onAvatarRepresentativeColorUpdated = function1;
    }

    public final void setOnBadgeClick(Function1<? super Badge, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onBadgeClick = function1;
    }

    public final void setOnBannerPress(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onBannerPress = function0;
    }

    public final void updateBannerColor(UserProfileHeaderViewModel$ViewState$Loaded viewState) {
        Integer numValueOf;
        m.checkNotNullParameter(viewState, "viewState");
        String bannerColorHex = viewState.getBannerColorHex();
        if (bannerColorHex != null) {
            try {
                numValueOf = Integer.valueOf(Color.parseColor(bannerColorHex));
            } catch (IllegalArgumentException e) {
                Logger.e$default(AppLog.g, a.w("failed to parse banner color string: ", bannerColorHex), e, null, 4, null);
                numValueOf = null;
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            this.binding.c.setBackgroundColor(numValueOf.intValue());
        }
        if (numValueOf == null) {
            updateBannerBackgroundColorAsync(viewState);
        }
    }

    public final void updateViewState(UserProfileHeaderViewModel$ViewState$Loaded viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        this.binding.f.setOnAvatarBitmapLoadedListener(new UserProfileHeaderView$updateViewState$1(viewState));
        this.binding.f.setOnClickListener(new UserProfileHeaderView$updateViewState$2(this, viewState));
        this.binding.f2166b.setOnClickListener(new UserProfileHeaderView$updateViewState$3(this, viewState));
        configureBanner(viewState);
        this.binding.f.a(new UserAvatarPresenceView$a(viewState.getUser(), viewState.getPresence(), viewState.getStreamContext(), viewState.getShowPresence(), viewState.getGuildMember()));
        configurePrimaryName(viewState);
        configureAka(viewState);
        configureSecondaryName(viewState);
        Badge$Companion badge$Companion = Badge.Companion;
        User user = viewState.getUser();
        UserProfile userProfile = viewState.getUserProfile();
        boolean zIsMeUserPremium = viewState.isMeUserPremium();
        boolean zIsMeUserVerified = viewState.isMeUserVerified();
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        this.badgesAdapter.setData(badge$Companion.getBadgesForUser(user, userProfile, zIsMeUserPremium, zIsMeUserVerified, context));
        Presence presence = viewState.getPresence();
        Activity customStatusActivity = presence != null ? PresenceUtils.INSTANCE.getCustomStatusActivity(presence) : null;
        if (customStatusActivity != null) {
            this.binding.i.setDraweeSpanStringBuilder(getCustomStatusDraweeSpanStringBuilder(customStatusActivity, viewState.getAllowAnimatedEmojis()));
        }
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.i;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.userProfileHeaderCustomStatus");
        simpleDraweeSpanTextView.setVisibility(customStatusActivity != null ? 0 : 8);
        CardView cardView = this.binding.f2166b;
        m.checkNotNullExpressionValue(cardView, "binding.avatarEdit");
        cardView.setVisibility(viewState.getEditable() ? 0 : 8);
        CardView cardView2 = this.binding.d;
        m.checkNotNullExpressionValue(cardView2, "binding.bannerEdit");
        cardView2.setVisibility(viewState.getEditable() ? 0 : 8);
    }
}
