package com.discord.utilities.textprocessing;

import a0.a.a.b;
import android.content.Context;
import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import com.discord.utilities.textprocessing.node.ChannelMentionNode$RenderContext;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import com.discord.utilities.textprocessing.node.EmojiNode$RenderContext;
import com.discord.utilities.textprocessing.node.RoleMentionNode$RenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.textprocessing.node.SpoilerNode$RenderContext;
import com.discord.utilities.textprocessing.node.TimestampNode$RenderContext;
import com.discord.utilities.textprocessing.node.UrlNode$RenderContext;
import com.discord.utilities.textprocessing.node.UserMentionNode$RenderContext;
import com.discord.widgets.emoji.WidgetEmojiSheet;
import d0.z.d.m;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MessageRenderContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessageRenderContext implements BasicRenderContext, UserMentionNode$RenderContext, EmojiNode$RenderContext, ChannelMentionNode$RenderContext, RoleMentionNode$RenderContext, UrlNode$RenderContext, SpoilerNode$RenderContext, TimestampNode$RenderContext {
    private final Function1<Long, Unit> channelMentionOnClick;
    private final Map<Long, String> channelNames;
    private final Context context;
    private final boolean isAnimationEnabled;
    private final int linkColorAttrResId;
    private final long myId;
    private final Function3<Context, String, String, Unit> onClickUrl;
    private final Function1<String, Unit> onLongPressUrl;
    private final Map<Long, GuildRole> roles;
    private final int spoilerColorRes;
    private final Function1<SpoilerNode<?>, Unit> spoilerOnClick;
    private final int spoilerRevealedColorRes;
    private final Function1<Long, Unit> userMentionOnClick;
    private final Map<Long, String> userNames;

    public MessageRenderContext(Context context, long j, boolean z2) {
        this(context, j, z2, null, null, null, 0, null, null, 0, 0, null, null, null, 16376, null);
    }

    public MessageRenderContext(Context context, long j, boolean z2, Map<Long, String> map) {
        this(context, j, z2, map, null, null, 0, null, null, 0, 0, null, null, null, 16368, null);
    }

    public MessageRenderContext(Context context, long j, boolean z2, Map<Long, String> map, Map<Long, String> map2) {
        this(context, j, z2, map, map2, null, 0, null, null, 0, 0, null, null, null, 16352, null);
    }

    public MessageRenderContext(Context context, long j, boolean z2, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3) {
        this(context, j, z2, map, map2, map3, 0, null, null, 0, 0, null, null, null, 16320, null);
    }

    public MessageRenderContext(Context context, long j, boolean z2, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, int i) {
        this(context, j, z2, map, map2, map3, i, null, null, 0, 0, null, null, null, 16256, null);
    }

    public MessageRenderContext(Context context, long j, boolean z2, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, int i, Function3<? super Context, ? super String, ? super String, Unit> function3) {
        this(context, j, z2, map, map2, map3, i, function3, null, 0, 0, null, null, null, 16128, null);
    }

    public MessageRenderContext(Context context, long j, boolean z2, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, int i, Function3<? super Context, ? super String, ? super String, Unit> function3, Function1<? super String, Unit> function1) {
        this(context, j, z2, map, map2, map3, i, function3, function1, 0, 0, null, null, null, 15872, null);
    }

    public MessageRenderContext(Context context, long j, boolean z2, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, int i, Function3<? super Context, ? super String, ? super String, Unit> function3, Function1<? super String, Unit> function1, int i2) {
        this(context, j, z2, map, map2, map3, i, function3, function1, i2, 0, null, null, null, 15360, null);
    }

    public MessageRenderContext(Context context, long j, boolean z2, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, int i, Function3<? super Context, ? super String, ? super String, Unit> function3, Function1<? super String, Unit> function1, int i2, int i3) {
        this(context, j, z2, map, map2, map3, i, function3, function1, i2, i3, null, null, null, 14336, null);
    }

    public MessageRenderContext(Context context, long j, boolean z2, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, int i, Function3<? super Context, ? super String, ? super String, Unit> function3, Function1<? super String, Unit> function1, int i2, int i3, Function1<? super SpoilerNode<?>, Unit> function2) {
        this(context, j, z2, map, map2, map3, i, function3, function1, i2, i3, function2, null, null, 12288, null);
    }

    public MessageRenderContext(Context context, long j, boolean z2, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, int i, Function3<? super Context, ? super String, ? super String, Unit> function3, Function1<? super String, Unit> function1, int i2, int i3, Function1<? super SpoilerNode<?>, Unit> function2, Function1<? super Long, Unit> function4) {
        this(context, j, z2, map, map2, map3, i, function3, function1, i2, i3, function2, function4, null, 8192, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessageRenderContext(Context context, long j, boolean z2, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, int i, Function3<? super Context, ? super String, ? super String, Unit> function3, Function1<? super String, Unit> function1, int i2, int i3, Function1<? super SpoilerNode<?>, Unit> function2, Function1<? super Long, Unit> function4, Function1<? super Long, Unit> function5) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(function3, "onClickUrl");
        m.checkNotNullParameter(function1, "onLongPressUrl");
        this.context = context;
        this.myId = j;
        this.isAnimationEnabled = z2;
        this.userNames = map;
        this.channelNames = map2;
        this.roles = map3;
        this.linkColorAttrResId = i;
        this.onClickUrl = function3;
        this.onLongPressUrl = function1;
        this.spoilerColorRes = i2;
        this.spoilerRevealedColorRes = i3;
        this.spoilerOnClick = function2;
        this.userMentionOnClick = function4;
        this.channelMentionOnClick = function5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageRenderContext copy$default(MessageRenderContext messageRenderContext, Context context, long j, boolean z2, Map map, Map map2, Map map3, int i, Function3 function3, Function1 function1, int i2, int i3, Function1 function2, Function1 function4, Function1 function5, int i4, Object obj) {
        return messageRenderContext.copy((i4 & 1) != 0 ? messageRenderContext.getContext() : context, (i4 & 2) != 0 ? messageRenderContext.getMyId() : j, (i4 & 4) != 0 ? messageRenderContext.getIsAnimationEnabled() : z2, (i4 & 8) != 0 ? messageRenderContext.getUserNames() : map, (i4 & 16) != 0 ? messageRenderContext.getChannelNames() : map2, (i4 & 32) != 0 ? messageRenderContext.getRoles() : map3, (i4 & 64) != 0 ? messageRenderContext.getLinkColorAttrResId() : i, (i4 & 128) != 0 ? messageRenderContext.getOnClickUrl() : function3, (i4 & 256) != 0 ? messageRenderContext.getOnLongPressUrl() : function1, (i4 & 512) != 0 ? messageRenderContext.getSpoilerColorRes() : i2, (i4 & 1024) != 0 ? messageRenderContext.getSpoilerRevealedColorRes() : i3, (i4 & 2048) != 0 ? messageRenderContext.getSpoilerOnClick() : function2, (i4 & 4096) != 0 ? messageRenderContext.getUserMentionOnClick() : function4, (i4 & 8192) != 0 ? messageRenderContext.getChannelMentionOnClick() : function5);
    }

    public final Context component1() {
        return getContext();
    }

    public final int component10() {
        return getSpoilerColorRes();
    }

    public final int component11() {
        return getSpoilerRevealedColorRes();
    }

    public final Function1<SpoilerNode<?>, Unit> component12() {
        return getSpoilerOnClick();
    }

    public final Function1<Long, Unit> component13() {
        return getUserMentionOnClick();
    }

    public final Function1<Long, Unit> component14() {
        return getChannelMentionOnClick();
    }

    public final long component2() {
        return getMyId();
    }

    public final boolean component3() {
        return getIsAnimationEnabled();
    }

    public final Map<Long, String> component4() {
        return getUserNames();
    }

    public final Map<Long, String> component5() {
        return getChannelNames();
    }

    public final Map<Long, GuildRole> component6() {
        return getRoles();
    }

    public final int component7() {
        return getLinkColorAttrResId();
    }

    public final Function3<Context, String, String, Unit> component8() {
        return getOnClickUrl();
    }

    public final Function1<String, Unit> component9() {
        return getOnLongPressUrl();
    }

    public final MessageRenderContext copy(Context context, long myId, boolean isAnimationEnabled, Map<Long, String> userNames, Map<Long, String> channelNames, Map<Long, GuildRole> roles, int linkColorAttrResId, Function3<? super Context, ? super String, ? super String, Unit> onClickUrl, Function1<? super String, Unit> onLongPressUrl, int spoilerColorRes, int spoilerRevealedColorRes, Function1<? super SpoilerNode<?>, Unit> spoilerOnClick, Function1<? super Long, Unit> userMentionOnClick, Function1<? super Long, Unit> channelMentionOnClick) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(onClickUrl, "onClickUrl");
        m.checkNotNullParameter(onLongPressUrl, "onLongPressUrl");
        return new MessageRenderContext(context, myId, isAnimationEnabled, userNames, channelNames, roles, linkColorAttrResId, onClickUrl, onLongPressUrl, spoilerColorRes, spoilerRevealedColorRes, spoilerOnClick, userMentionOnClick, channelMentionOnClick);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageRenderContext)) {
            return false;
        }
        MessageRenderContext messageRenderContext = (MessageRenderContext) other;
        return m.areEqual(getContext(), messageRenderContext.getContext()) && getMyId() == messageRenderContext.getMyId() && getIsAnimationEnabled() == messageRenderContext.getIsAnimationEnabled() && m.areEqual(getUserNames(), messageRenderContext.getUserNames()) && m.areEqual(getChannelNames(), messageRenderContext.getChannelNames()) && m.areEqual(getRoles(), messageRenderContext.getRoles()) && getLinkColorAttrResId() == messageRenderContext.getLinkColorAttrResId() && m.areEqual(getOnClickUrl(), messageRenderContext.getOnClickUrl()) && m.areEqual(getOnLongPressUrl(), messageRenderContext.getOnLongPressUrl()) && getSpoilerColorRes() == messageRenderContext.getSpoilerColorRes() && getSpoilerRevealedColorRes() == messageRenderContext.getSpoilerRevealedColorRes() && m.areEqual(getSpoilerOnClick(), messageRenderContext.getSpoilerOnClick()) && m.areEqual(getUserMentionOnClick(), messageRenderContext.getUserMentionOnClick()) && m.areEqual(getChannelMentionOnClick(), messageRenderContext.getChannelMentionOnClick());
    }

    @Override // com.discord.utilities.textprocessing.node.ChannelMentionNode$RenderContext
    public Function1<Long, Unit> getChannelMentionOnClick() {
        return this.channelMentionOnClick;
    }

    @Override // com.discord.utilities.textprocessing.node.ChannelMentionNode$RenderContext
    public Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    @Override // com.discord.utilities.textprocessing.node.BasicRenderContext, com.discord.utilities.textprocessing.node.UserMentionNode$RenderContext, com.discord.utilities.textprocessing.node.EmojiNode$RenderContext
    public Context getContext() {
        return this.context;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode$RenderContext
    public int getLinkColorAttrResId() {
        return this.linkColorAttrResId;
    }

    @Override // com.discord.utilities.textprocessing.node.UserMentionNode$RenderContext
    public long getMyId() {
        return this.myId;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode$RenderContext
    public Function3<Context, String, String, Unit> getOnClickUrl() {
        return this.onClickUrl;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode$RenderContext
    public Function1<String, Unit> getOnLongPressUrl() {
        return this.onLongPressUrl;
    }

    @Override // com.discord.utilities.textprocessing.node.RoleMentionNode$RenderContext
    public Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    @Override // com.discord.utilities.textprocessing.node.SpoilerNode$RenderContext
    public int getSpoilerColorRes() {
        return this.spoilerColorRes;
    }

    @Override // com.discord.utilities.textprocessing.node.SpoilerNode$RenderContext
    public Function1<SpoilerNode<?>, Unit> getSpoilerOnClick() {
        return this.spoilerOnClick;
    }

    @Override // com.discord.utilities.textprocessing.node.SpoilerNode$RenderContext
    public int getSpoilerRevealedColorRes() {
        return this.spoilerRevealedColorRes;
    }

    @Override // com.discord.utilities.textprocessing.node.UserMentionNode$RenderContext
    public Function1<Long, Unit> getUserMentionOnClick() {
        return this.userMentionOnClick;
    }

    @Override // com.discord.utilities.textprocessing.node.UserMentionNode$RenderContext
    public Map<Long, String> getUserNames() {
        return this.userNames;
    }

    public int hashCode() {
        Context context = getContext();
        int iA = (b.a(getMyId()) + ((context != null ? context.hashCode() : 0) * 31)) * 31;
        boolean isAnimationEnabled = getIsAnimationEnabled();
        int i = isAnimationEnabled;
        if (isAnimationEnabled) {
            i = 1;
        }
        int i2 = (iA + i) * 31;
        Map<Long, String> userNames = getUserNames();
        int iHashCode = (i2 + (userNames != null ? userNames.hashCode() : 0)) * 31;
        Map<Long, String> channelNames = getChannelNames();
        int iHashCode2 = (iHashCode + (channelNames != null ? channelNames.hashCode() : 0)) * 31;
        Map<Long, GuildRole> roles = getRoles();
        int linkColorAttrResId = (getLinkColorAttrResId() + ((iHashCode2 + (roles != null ? roles.hashCode() : 0)) * 31)) * 31;
        Function3<Context, String, String, Unit> onClickUrl = getOnClickUrl();
        int iHashCode3 = (linkColorAttrResId + (onClickUrl != null ? onClickUrl.hashCode() : 0)) * 31;
        Function1<String, Unit> onLongPressUrl = getOnLongPressUrl();
        int spoilerRevealedColorRes = (getSpoilerRevealedColorRes() + ((getSpoilerColorRes() + ((iHashCode3 + (onLongPressUrl != null ? onLongPressUrl.hashCode() : 0)) * 31)) * 31)) * 31;
        Function1<SpoilerNode<?>, Unit> spoilerOnClick = getSpoilerOnClick();
        int iHashCode4 = (spoilerRevealedColorRes + (spoilerOnClick != null ? spoilerOnClick.hashCode() : 0)) * 31;
        Function1<Long, Unit> userMentionOnClick = getUserMentionOnClick();
        int iHashCode5 = (iHashCode4 + (userMentionOnClick != null ? userMentionOnClick.hashCode() : 0)) * 31;
        Function1<Long, Unit> channelMentionOnClick = getChannelMentionOnClick();
        return iHashCode5 + (channelMentionOnClick != null ? channelMentionOnClick.hashCode() : 0);
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode$RenderContext
    /* JADX INFO: renamed from: isAnimationEnabled, reason: from getter */
    public boolean getIsAnimationEnabled() {
        return this.isAnimationEnabled;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode$RenderContext
    public void onEmojiClicked(EmojiNode$EmojiIdAndType emojiIdAndType) {
        m.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
        WidgetEmojiSheet.Companion.enqueueNotice(emojiIdAndType);
    }

    @Override // com.discord.utilities.textprocessing.node.TimestampNode$RenderContext
    public void onTimestampClicked(CharSequence full) {
        m.checkNotNullParameter(full, "full");
        b.a.d.m.h(getContext(), full, 0, null, 12);
    }

    public String toString() {
        StringBuilder sbU = a.U("MessageRenderContext(context=");
        sbU.append(getContext());
        sbU.append(", myId=");
        sbU.append(getMyId());
        sbU.append(", isAnimationEnabled=");
        sbU.append(getIsAnimationEnabled());
        sbU.append(", userNames=");
        sbU.append(getUserNames());
        sbU.append(", channelNames=");
        sbU.append(getChannelNames());
        sbU.append(", roles=");
        sbU.append(getRoles());
        sbU.append(", linkColorAttrResId=");
        sbU.append(getLinkColorAttrResId());
        sbU.append(", onClickUrl=");
        sbU.append(getOnClickUrl());
        sbU.append(", onLongPressUrl=");
        sbU.append(getOnLongPressUrl());
        sbU.append(", spoilerColorRes=");
        sbU.append(getSpoilerColorRes());
        sbU.append(", spoilerRevealedColorRes=");
        sbU.append(getSpoilerRevealedColorRes());
        sbU.append(", spoilerOnClick=");
        sbU.append(getSpoilerOnClick());
        sbU.append(", userMentionOnClick=");
        sbU.append(getUserMentionOnClick());
        sbU.append(", channelMentionOnClick=");
        sbU.append(getChannelMentionOnClick());
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ MessageRenderContext(Context context, long j, boolean z2, Map map, Map map2, Map map3, int i, Function3 function3, Function1 function1, int i2, int i3, Function1 function2, Function1 function4, Function1 function5, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, j, z2, (i4 & 8) != 0 ? null : map, (i4 & 16) != 0 ? null : map2, (i4 & 32) != 0 ? null : map3, (i4 & 64) != 0 ? 2130969054 : i, (i4 & 128) != 0 ? MessageRenderContext$1.INSTANCE : function3, (i4 & 256) != 0 ? MessageRenderContext$2.INSTANCE : function1, (i4 & 512) != 0 ? ColorCompat.getThemedColor(context, 2130970291) : i2, (i4 & 1024) != 0 ? ColorCompat.getThemedColor(context, 2130970292) : i3, (i4 & 2048) != 0 ? null : function2, (i4 & 4096) != 0 ? null : function4, (i4 & 8192) != 0 ? null : function5);
    }
}
