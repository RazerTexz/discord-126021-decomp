package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreEmojiGuild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Model$Companion {
    private WidgetServerSettingsEmojis$Model$Companion() {
    }

    public static final /* synthetic */ WidgetServerSettingsEmojis$Model access$create(WidgetServerSettingsEmojis$Model$Companion widgetServerSettingsEmojis$Model$Companion, Guild guild, List list, Map map) {
        return widgetServerSettingsEmojis$Model$Companion.create(guild, list, map);
    }

    public static final /* synthetic */ Observable access$getGuildEmojis(WidgetServerSettingsEmojis$Model$Companion widgetServerSettingsEmojis$Model$Companion, Guild guild) {
        return widgetServerSettingsEmojis$Model$Companion.getGuildEmojis(guild);
    }

    private final Observable<WidgetServerSettingsEmojis$Model$Permission> canManageEmojisAndStickers(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableI = Observable.i(storeStream$Companion.getPermissions().observePermissionsForGuild(guildId), storeStream$Companion.getGuilds().observeGuild(guildId), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), WidgetServerSettingsEmojis$Model$Companion$canManageEmojisAndStickers$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…ld)\n          }\n        }");
        return ObservableExtensionsKt.computationBuffered(observableI);
    }

    private final WidgetServerSettingsEmojis$Model create(Guild guild, List<ModelEmojiGuild> emojis, Map<Long, GuildMember> guildMembers) {
        if (emojis == null) {
            return new WidgetServerSettingsEmojis$Model(guild, null, null);
        }
        int guildEmojiMaxCount = PremiumUtils.INSTANCE.getGuildEmojiMaxCount(guild);
        WidgetServerSettingsEmojis$Item$EmojiHeader widgetServerSettingsEmojis$Item$EmojiHeader = new WidgetServerSettingsEmojis$Item$EmojiHeader(guildEmojiMaxCount);
        ArrayList arrayList = new ArrayList();
        for (Object obj : emojis) {
            if (!((ModelEmojiGuild) obj).getAnimated()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(WidgetServerSettingsEmojis$Item$EmojiItem.Companion.from((ModelEmojiGuild) it.next(), guildMembers));
        }
        List listReversed = u.reversed(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : emojis) {
            if (((ModelEmojiGuild) obj2).getAnimated()) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(o.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(WidgetServerSettingsEmojis$Item$EmojiItem.Companion.from((ModelEmojiGuild) it2.next(), guildMembers));
        }
        List listReversed2 = u.reversed(arrayList4);
        WidgetServerSettingsEmojis$Item$EmojiSection widgetServerSettingsEmojis$Item$EmojiSection = new WidgetServerSettingsEmojis$Item$EmojiSection(guildEmojiMaxCount, listReversed.size(), 2131888749);
        WidgetServerSettingsEmojis$Item$EmojiSection widgetServerSettingsEmojis$Item$EmojiSection2 = new WidgetServerSettingsEmojis$Item$EmojiSection(guildEmojiMaxCount, listReversed2.size(), 2131886429);
        ArrayList arrayList5 = new ArrayList(d0.t.m.listOf(widgetServerSettingsEmojis$Item$EmojiHeader));
        if (!listReversed.isEmpty()) {
            arrayList5.addAll(u.plus((Collection) d0.t.m.listOf(widgetServerSettingsEmojis$Item$EmojiSection), (Iterable) listReversed));
        }
        if (!listReversed2.isEmpty()) {
            arrayList5.addAll(u.plus((Collection) d0.t.m.listOf(widgetServerSettingsEmojis$Item$EmojiSection2), (Iterable) listReversed2));
        }
        if (listReversed.isEmpty() && listReversed2.isEmpty()) {
            arrayList5.addAll(d0.t.m.listOf(WidgetServerSettingsEmojis$Item$EmojiEmpty.INSTANCE));
        }
        StringBuilder sbU = a.U("emoji_");
        sbU.append(emojis.size() + 1);
        return new WidgetServerSettingsEmojis$Model(guild, arrayList5, sbU.toString());
    }

    private final Observable<WidgetServerSettingsEmojis$Model> getGuildEmojis(Guild guild) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreEmojiGuild guildEmojis = storeStream$Companion.getGuildEmojis();
        StoreGuilds guilds = storeStream$Companion.getGuilds();
        Observable observableV = ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{guildEmojis, guilds}, false, null, null, new WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$1(guild, guildEmojis, guilds), 14, null).v(new WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$2(guildEmojis, guild.getId()));
        m.checkNotNullExpressionValue(observableV, "ObservationDeckProvider.…etchGuildEmoji(guildId) }");
        return ObservableExtensionsKt.computationBuffered(observableV);
    }

    public final Observable<WidgetServerSettingsEmojis$Model> get(long guildId) {
        Observable observableY = canManageEmojisAndStickers(guildId).Y(WidgetServerSettingsEmojis$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "canManageEmojisAndSticke…          }\n            }");
        return observableY;
    }

    public /* synthetic */ WidgetServerSettingsEmojis$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
