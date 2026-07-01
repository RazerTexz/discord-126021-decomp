package b.a.b;

import b.i.d.e;
import com.discord.api.activity.ActivityPlatform;
import com.discord.api.activity.ActivityType;
import com.discord.api.application.ApplicationType;
import com.discord.api.auth.OAuthScope;
import com.discord.api.auth.RequiredAction;
import com.discord.api.botuikit.ButtonStyle;
import com.discord.api.botuikit.ComponentType;
import com.discord.api.botuikit.TextStyle;
import com.discord.api.botuikit.gson.ComponentRuntimeTypeAdapter;
import com.discord.api.commands.ApplicationCommandPermissionType;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import com.discord.api.friendsuggestions.FriendSuggestionReasonType;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildHubType;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.PayoutGroupStatus;
import com.discord.api.guildrolesubscription.PayoutGroupType;
import com.discord.api.guildrolesubscription.PayoutStatus;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.localizedstring.LocalizedString;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.premium.PremiumTier;
import com.discord.api.premium.PriceTierType;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.api.report.ReportNodeChild;
import com.discord.api.report.ReportNodeElementData;
import com.discord.api.science.Science$Event$SchemaObject;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.sticker.StickerFormatType;
import com.discord.api.sticker.StickerType;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.Phone;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.nullserializable.NullSerializableTypeAdapterFactory;
import d0.o;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: TypeAdapterRegistrar.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final Map<Class<? extends Object>, Function0<Object>> a = h0.mapOf(o.to(ActivityPlatform.class, a$b.j), o.to(ActivityType.class, a$a.D), o.to(ActivityType.class, a$a.O), o.to(AllowedInSuggestionsType.class, a$a.P), o.to(ApplicationCommandPermissionType.class, a$a.Q), o.to(ApplicationCommandType.class, a$a.R), o.to(ApplicationStatus.class, a$a.S), o.to(ApplicationType.class, a$a.T), o.to(ButtonStyle.class, a$a.U), o.to(ComponentType.class, a$a.j), o.to(EmbedType.class, a$a.k), o.to(FriendSuggestionReasonType.class, a$a.l), o.to(GuildExplicitContentFilter.class, a$a.m), o.to(GuildHubType.class, a$a.n), o.to(GuildMaxVideoChannelUsers.class, a$a.o), o.to(GuildRoleSubscriptionBenefitType.class, a$a.p), o.to(GuildScheduledEventEntityType.class, a$a.q), o.to(GuildScheduledEventStatus.class, a$a.r), o.to(GuildVerificationLevel.class, a$a.f52s), o.to(LocalizedString.class, a$a.t), o.to(MessageActivityType.class, a$a.u), o.to(NsfwAllowance.class, a$a.v), o.to(OAuthScope.class, a$a.w), o.to(PayoutGroupStatus.class, a$a.f53x), o.to(PayoutGroupType.class, a$a.f54y), o.to(PayoutStatus.class, a$a.f55z), o.to(Phone.class, a$a.A), o.to(PremiumTier.class, a$a.B), o.to(PriceTierType.class, a$a.C), o.to(ReportNodeBottomButton.class, a$a.E), o.to(ReportNodeChild.class, a$a.F), o.to(ReportNodeElementData.class, a$a.G), o.to(RequiredAction.class, a$a.H), o.to(Science$Event$SchemaObject.class, a$a.I), o.to(StageInstancePrivacyLevel.class, a$a.J), o.to(StickerFormatType.class, a$a.K), o.to(StickerType.class, a$a.L), o.to(TextStyle.class, a$a.M), o.to(UtcDateTime.class, a$a.N));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<b.i.d.o> f51b = n.listOf((Object[]) new b.i.d.o[]{ComponentRuntimeTypeAdapter.INSTANCE.a(), new NullSerializableTypeAdapterFactory()});

    public static final e a(e eVar) {
        m.checkNotNullParameter(eVar, "$this$registerDiscordApiTypeAdapters");
        for (Map$Entry<Class<? extends Object>, Function0<Object>> map$Entry : a.entrySet()) {
            eVar.b(map$Entry.getKey(), map$Entry.getValue().invoke());
        }
        m.checkNotNullParameter(eVar, "$this$registerDiscordApiTypeAdapterFactories");
        Iterator<T> it = f51b.iterator();
        while (it.hasNext()) {
            eVar.e.add((b.i.d.o) it.next());
        }
        return eVar;
    }
}
