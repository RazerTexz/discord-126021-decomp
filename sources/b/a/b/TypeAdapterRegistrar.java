package b.a.b;

import b.i.d.GsonBuilder;
import b.i.d.TypeAdapterFactory2;
import com.discord.api.activity.ActivityPlatform;
import com.discord.api.activity.ActivityPlatform2;
import com.discord.api.activity.ActivityType;
import com.discord.api.activity.ActivityType2;
import com.discord.api.application.ApplicationType;
import com.discord.api.application.ApplicationType2;
import com.discord.api.auth.OAuthScope;
import com.discord.api.auth.OAuthScopeTypeAdapter;
import com.discord.api.auth.RequiredAction;
import com.discord.api.auth.RequiredAction2;
import com.discord.api.botuikit.ButtonComponent2;
import com.discord.api.botuikit.ButtonComponent3;
import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.TextComponent2;
import com.discord.api.botuikit.TextComponent3;
import com.discord.api.botuikit.gson.ComponentRuntimeTypeAdapter;
import com.discord.api.botuikit.gson.ComponentTypeTypeAdapter;
import com.discord.api.commands.ApplicationCommandPermission2;
import com.discord.api.commands.ApplicationCommandPermission3;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.ApplicationCommandType2;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType2;
import com.discord.api.friendsuggestions.FriendSuggestionReasonType;
import com.discord.api.friendsuggestions.FriendSuggestionReasonType2;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildExplicitContentFilter2;
import com.discord.api.guild.GuildHubType;
import com.discord.api.guild.GuildHubType2;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildMaxVideoChannelUsers2;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guild.GuildVerificationLevel2;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.ApplicationStatus2;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType2;
import com.discord.api.guildrolesubscription.PayoutGroupStatus;
import com.discord.api.guildrolesubscription.PayoutGroupStatus2;
import com.discord.api.guildrolesubscription.PayoutGroupType;
import com.discord.api.guildrolesubscription.PayoutGroupType2;
import com.discord.api.guildrolesubscription.PayoutStatus;
import com.discord.api.guildrolesubscription.PayoutStatus2;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType2;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus2;
import com.discord.api.localizedstring.LocalizedString;
import com.discord.api.localizedstring.LocalizedString2;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.activity.MessageActivityType2;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.EmbedType3;
import com.discord.api.premium.PremiumTier;
import com.discord.api.premium.PremiumTier2;
import com.discord.api.premium.PriceTierType;
import com.discord.api.premium.PriceTierType2;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.api.report.ReportNodeBottomButtonTypeAdapter;
import com.discord.api.report.ReportNodeChild;
import com.discord.api.report.ReportNodeChildTypeAdapter;
import com.discord.api.report.ReportNodeElementData;
import com.discord.api.report.ReportNodeElementDataTypeAdapter;
import com.discord.api.science.AnalyticsSchemaTypeAdapter;
import com.discord.api.science.Science;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.stageinstance.StageInstancePrivacyLevel2;
import com.discord.api.sticker.StickerFormatType;
import com.discord.api.sticker.StickerFormatType2;
import com.discord.api.sticker.StickerType;
import com.discord.api.sticker.StickerType2;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.NsfwAllowance2;
import com.discord.api.user.Phone;
import com.discord.api.user.Phone2;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.api.utcdatetime.UtcDateTime2;
import com.discord.nullserializable.NullSerializable3;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.b.a, reason: use source file name */
/* JADX INFO: compiled from: TypeAdapterRegistrar.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeAdapterRegistrar {
    public static final Map<Class<? extends Object>, Function0<Object>> a = Maps6.mapOf(Tuples.to(ActivityPlatform.class, b.j), Tuples.to(ActivityType.class, a.D), Tuples.to(ActivityType.class, a.O), Tuples.to(AllowedInSuggestionsType.class, a.P), Tuples.to(ApplicationCommandPermission2.class, a.Q), Tuples.to(ApplicationCommandType.class, a.R), Tuples.to(ApplicationStatus.class, a.S), Tuples.to(ApplicationType.class, a.T), Tuples.to(ButtonComponent2.class, a.U), Tuples.to(Component6.class, a.j), Tuples.to(EmbedType.class, a.k), Tuples.to(FriendSuggestionReasonType.class, a.l), Tuples.to(GuildExplicitContentFilter.class, a.m), Tuples.to(GuildHubType.class, a.n), Tuples.to(GuildMaxVideoChannelUsers.class, a.o), Tuples.to(GuildRoleSubscriptionBenefitType.class, a.p), Tuples.to(GuildScheduledEventEntityType.class, a.q), Tuples.to(GuildScheduledEventStatus.class, a.r), Tuples.to(GuildVerificationLevel.class, a.f52s), Tuples.to(LocalizedString.class, a.t), Tuples.to(MessageActivityType.class, a.u), Tuples.to(NsfwAllowance.class, a.v), Tuples.to(OAuthScope.class, a.w), Tuples.to(PayoutGroupStatus.class, a.f53x), Tuples.to(PayoutGroupType.class, a.f54y), Tuples.to(PayoutStatus.class, a.f55z), Tuples.to(Phone.class, a.A), Tuples.to(PremiumTier.class, a.B), Tuples.to(PriceTierType.class, a.C), Tuples.to(ReportNodeBottomButton.class, a.E), Tuples.to(ReportNodeChild.class, a.F), Tuples.to(ReportNodeElementData.class, a.G), Tuples.to(RequiredAction.class, a.H), Tuples.to(Science.Event.SchemaObject.class, a.I), Tuples.to(StageInstancePrivacyLevel.class, a.J), Tuples.to(StickerFormatType.class, a.K), Tuples.to(StickerType.class, a.L), Tuples.to(TextComponent2.class, a.M), Tuples.to(UtcDateTime.class, a.N));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<TypeAdapterFactory2> f51b = Collections2.listOf((Object[]) new TypeAdapterFactory2[]{ComponentRuntimeTypeAdapter.INSTANCE.a(), new NullSerializable3()});

    /* JADX INFO: renamed from: b.a.b.a$a */
    /* JADX INFO: compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Object> {
        public final /* synthetic */ int V;
        public static final a j = new a(0);
        public static final a k = new a(1);
        public static final a l = new a(2);
        public static final a m = new a(3);
        public static final a n = new a(4);
        public static final a o = new a(5);
        public static final a p = new a(6);
        public static final a q = new a(7);
        public static final a r = new a(8);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f52s = new a(9);
        public static final a t = new a(10);
        public static final a u = new a(11);
        public static final a v = new a(12);
        public static final a w = new a(13);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final a f53x = new a(14);

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final a f54y = new a(15);

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final a f55z = new a(16);
        public static final a A = new a(17);
        public static final a B = new a(18);
        public static final a C = new a(19);
        public static final a D = new a(20);
        public static final a E = new a(21);
        public static final a F = new a(22);
        public static final a G = new a(23);
        public static final a H = new a(24);
        public static final a I = new a(25);
        public static final a J = new a(26);
        public static final a K = new a(27);
        public static final a L = new a(28);
        public static final a M = new a(29);
        public static final a N = new a(30);
        public static final a O = new a(31);
        public static final a P = new a(32);
        public static final a Q = new a(33);
        public static final a R = new a(34);
        public static final a S = new a(35);
        public static final a T = new a(36);
        public static final a U = new a(37);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(0);
            this.V = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            switch (this.V) {
                case 0:
                    return new ComponentTypeTypeAdapter();
                case 1:
                    return new EmbedType3();
                case 2:
                    return new FriendSuggestionReasonType2();
                case 3:
                    return new GuildExplicitContentFilter2();
                case 4:
                    return new GuildHubType2();
                case 5:
                    return new GuildMaxVideoChannelUsers2();
                case 6:
                    return new GuildRoleSubscriptionBenefitType2();
                case 7:
                    return new GuildScheduledEventEntityType2();
                case 8:
                    return new GuildScheduledEventStatus2();
                case 9:
                    return new GuildVerificationLevel2();
                case 10:
                    return new LocalizedString2();
                case 11:
                    return new MessageActivityType2();
                case 12:
                    return new NsfwAllowance2();
                case 13:
                    return new OAuthScopeTypeAdapter();
                case 14:
                    return new PayoutGroupStatus2();
                case 15:
                    return new PayoutGroupType2();
                case 16:
                    return new PayoutStatus2();
                case 17:
                    return new Phone2();
                case 18:
                    return new PremiumTier2();
                case 19:
                    return new PriceTierType2();
                case 20:
                    return new ActivityType2();
                case 21:
                    return new ReportNodeBottomButtonTypeAdapter();
                case 22:
                    return new ReportNodeChildTypeAdapter();
                case 23:
                    return new ReportNodeElementDataTypeAdapter();
                case 24:
                    return new RequiredAction2();
                case 25:
                    return new AnalyticsSchemaTypeAdapter();
                case 26:
                    return new StageInstancePrivacyLevel2();
                case 27:
                    return new StickerFormatType2();
                case 28:
                    return new StickerType2();
                case 29:
                    return new TextComponent3();
                case 30:
                    return new UtcDateTime2();
                case 31:
                    return new ActivityType2();
                case 32:
                    return new AllowedInSuggestionsType2();
                case 33:
                    return new ApplicationCommandPermission3();
                case 34:
                    return new ApplicationCommandType2();
                case 35:
                    return new ApplicationStatus2();
                case 36:
                    return new ApplicationType2();
                case 37:
                    return new ButtonComponent3();
                default:
                    throw null;
            }
        }
    }

    /* JADX INFO: renamed from: b.a.b.a$b */
    /* JADX INFO: compiled from: TypeAdapterRegistrar.kt */
    public static final class b extends Lambda implements Function0<ActivityPlatform2> {
        public static final b j = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ActivityPlatform2 invoke() {
            return new ActivityPlatform2();
        }
    }

    public static final GsonBuilder a(GsonBuilder gsonBuilder) {
        Intrinsics3.checkNotNullParameter(gsonBuilder, "$this$registerDiscordApiTypeAdapters");
        for (Map.Entry<Class<? extends Object>, Function0<Object>> entry : a.entrySet()) {
            gsonBuilder.b(entry.getKey(), entry.getValue().invoke());
        }
        Intrinsics3.checkNotNullParameter(gsonBuilder, "$this$registerDiscordApiTypeAdapterFactories");
        Iterator<T> it = f51b.iterator();
        while (it.hasNext()) {
            gsonBuilder.e.add((TypeAdapterFactory2) it.next());
        }
        return gsonBuilder;
    }
}
