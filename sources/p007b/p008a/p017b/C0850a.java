package p007b.p008a.p017b;

import com.discord.api.activity.ActivityPlatform;
import com.discord.api.activity.ActivityPlatformTypeAdapter;
import com.discord.api.activity.ActivityType;
import com.discord.api.activity.ActivityTypeTypeAdapter;
import com.discord.api.application.ApplicationType;
import com.discord.api.application.ApplicationTypeAdapter;
import com.discord.api.auth.OAuthScope;
import com.discord.api.auth.OAuthScopeTypeAdapter;
import com.discord.api.auth.RequiredAction;
import com.discord.api.auth.RequiredActionTypeAdapter;
import com.discord.api.botuikit.ButtonStyle;
import com.discord.api.botuikit.ButtonStyleTypeAdapter;
import com.discord.api.botuikit.ComponentType;
import com.discord.api.botuikit.TextStyle;
import com.discord.api.botuikit.TextStyleTypeAdapter;
import com.discord.api.botuikit.gson.ComponentRuntimeTypeAdapter;
import com.discord.api.botuikit.gson.ComponentTypeTypeAdapter;
import com.discord.api.commands.ApplicationCommandPermissionType;
import com.discord.api.commands.ApplicationCommandPermissionTypeTypeAdapter;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandTypeAdapter;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import com.discord.api.friendsuggestions.AllowedInSuggestionsTypeAdapter;
import com.discord.api.friendsuggestions.FriendSuggestionReasonType;
import com.discord.api.friendsuggestions.FriendSuggestionReasonTypeAdapter;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildExplicitContentFilterTypeAdapter;
import com.discord.api.guild.GuildHubType;
import com.discord.api.guild.GuildHubTypeTypeAdapter;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildMaxVideoChannelUsersTypeAdapter;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guild.GuildVerificationLevelTypeAdapter;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.ApplicationStatusTypeAdapter;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitTypeAdapter;
import com.discord.api.guildrolesubscription.PayoutGroupStatus;
import com.discord.api.guildrolesubscription.PayoutGroupStatusTypeAdapter;
import com.discord.api.guildrolesubscription.PayoutGroupType;
import com.discord.api.guildrolesubscription.PayoutGroupTypeAdapter;
import com.discord.api.guildrolesubscription.PayoutStatus;
import com.discord.api.guildrolesubscription.PayoutStatusAdapter;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityTypeTypeAdapter;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatusTypeAdapter;
import com.discord.api.localizedstring.LocalizedString;
import com.discord.api.localizedstring.LocalizedStringTypeAdapter;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.activity.MessageActivityTypeTypeAdapter;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.EmbedTypeTypeAdapter;
import com.discord.api.premium.PremiumTier;
import com.discord.api.premium.PremiumTierTypeAdapter;
import com.discord.api.premium.PriceTierType;
import com.discord.api.premium.PriceTierTypeAdapter;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.api.report.ReportNodeBottomButtonTypeAdapter;
import com.discord.api.report.ReportNodeChild;
import com.discord.api.report.ReportNodeChildTypeAdapter;
import com.discord.api.report.ReportNodeElementData;
import com.discord.api.report.ReportNodeElementDataTypeAdapter;
import com.discord.api.science.AnalyticsSchemaTypeAdapter;
import com.discord.api.science.Science;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.stageinstance.StageInstancePrivacyLevelTypeAdapter;
import com.discord.api.sticker.StickerFormatType;
import com.discord.api.sticker.StickerFormatTypeTypeAdapter;
import com.discord.api.sticker.StickerType;
import com.discord.api.sticker.StickerTypeTypeAdapter;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.NsfwAllowanceTypeAdapter;
import com.discord.api.user.Phone;
import com.discord.api.user.PhoneTypeAdapter;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.api.utcdatetime.UtcDateTimeTypeAdapter;
import com.discord.nullserializable.NullSerializableTypeAdapterFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p007b.p225i.p408d.C4901e;
import p007b.p225i.p408d.InterfaceC4911o;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.b.a */
/* JADX INFO: compiled from: TypeAdapterRegistrar.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C0850a {

    /* JADX INFO: renamed from: a */
    public static final Map<Class<? extends Object>, Function0<Object>> f454a = C12136h0.mapOf(C12116o.m10073to(ActivityPlatform.class, b.f495j), C12116o.m10073to(ActivityType.class, a.f459D), C12116o.m10073to(ActivityType.class, a.f470O), C12116o.m10073to(AllowedInSuggestionsType.class, a.f471P), C12116o.m10073to(ApplicationCommandPermissionType.class, a.f472Q), C12116o.m10073to(ApplicationCommandType.class, a.f473R), C12116o.m10073to(ApplicationStatus.class, a.f474S), C12116o.m10073to(ApplicationType.class, a.f475T), C12116o.m10073to(ButtonStyle.class, a.f476U), C12116o.m10073to(ComponentType.class, a.f477j), C12116o.m10073to(EmbedType.class, a.f478k), C12116o.m10073to(FriendSuggestionReasonType.class, a.f479l), C12116o.m10073to(GuildExplicitContentFilter.class, a.f480m), C12116o.m10073to(GuildHubType.class, a.f481n), C12116o.m10073to(GuildMaxVideoChannelUsers.class, a.f482o), C12116o.m10073to(GuildRoleSubscriptionBenefitType.class, a.f483p), C12116o.m10073to(GuildScheduledEventEntityType.class, a.f484q), C12116o.m10073to(GuildScheduledEventStatus.class, a.f485r), C12116o.m10073to(GuildVerificationLevel.class, a.f486s), C12116o.m10073to(LocalizedString.class, a.f487t), C12116o.m10073to(MessageActivityType.class, a.f488u), C12116o.m10073to(NsfwAllowance.class, a.f489v), C12116o.m10073to(OAuthScope.class, a.f490w), C12116o.m10073to(PayoutGroupStatus.class, a.f491x), C12116o.m10073to(PayoutGroupType.class, a.f492y), C12116o.m10073to(PayoutStatus.class, a.f493z), C12116o.m10073to(Phone.class, a.f456A), C12116o.m10073to(PremiumTier.class, a.f457B), C12116o.m10073to(PriceTierType.class, a.f458C), C12116o.m10073to(ReportNodeBottomButton.class, a.f460E), C12116o.m10073to(ReportNodeChild.class, a.f461F), C12116o.m10073to(ReportNodeElementData.class, a.f462G), C12116o.m10073to(RequiredAction.class, a.f463H), C12116o.m10073to(Science.Event.SchemaObject.class, a.f464I), C12116o.m10073to(StageInstancePrivacyLevel.class, a.f465J), C12116o.m10073to(StickerFormatType.class, a.f466K), C12116o.m10073to(StickerType.class, a.f467L), C12116o.m10073to(TextStyle.class, a.f468M), C12116o.m10073to(UtcDateTime.class, a.f469N));

    /* JADX INFO: renamed from: b */
    public static final List<InterfaceC4911o> f455b = C12147n.listOf((Object[]) new InterfaceC4911o[]{ComponentRuntimeTypeAdapter.INSTANCE.m7624a(), new NullSerializableTypeAdapterFactory()});

    /* JADX INFO: renamed from: b.a.b.a$a */
    /* JADX INFO: compiled from: kotlin-style lambda group */
    public static final class a extends AbstractC12240o implements Function0<Object> {

        /* JADX INFO: renamed from: V */
        public final /* synthetic */ int f494V;

        /* JADX INFO: renamed from: j */
        public static final a f477j = new a(0);

        /* JADX INFO: renamed from: k */
        public static final a f478k = new a(1);

        /* JADX INFO: renamed from: l */
        public static final a f479l = new a(2);

        /* JADX INFO: renamed from: m */
        public static final a f480m = new a(3);

        /* JADX INFO: renamed from: n */
        public static final a f481n = new a(4);

        /* JADX INFO: renamed from: o */
        public static final a f482o = new a(5);

        /* JADX INFO: renamed from: p */
        public static final a f483p = new a(6);

        /* JADX INFO: renamed from: q */
        public static final a f484q = new a(7);

        /* JADX INFO: renamed from: r */
        public static final a f485r = new a(8);

        /* JADX INFO: renamed from: s */
        public static final a f486s = new a(9);

        /* JADX INFO: renamed from: t */
        public static final a f487t = new a(10);

        /* JADX INFO: renamed from: u */
        public static final a f488u = new a(11);

        /* JADX INFO: renamed from: v */
        public static final a f489v = new a(12);

        /* JADX INFO: renamed from: w */
        public static final a f490w = new a(13);

        /* JADX INFO: renamed from: x */
        public static final a f491x = new a(14);

        /* JADX INFO: renamed from: y */
        public static final a f492y = new a(15);

        /* JADX INFO: renamed from: z */
        public static final a f493z = new a(16);

        /* JADX INFO: renamed from: A */
        public static final a f456A = new a(17);

        /* JADX INFO: renamed from: B */
        public static final a f457B = new a(18);

        /* JADX INFO: renamed from: C */
        public static final a f458C = new a(19);

        /* JADX INFO: renamed from: D */
        public static final a f459D = new a(20);

        /* JADX INFO: renamed from: E */
        public static final a f460E = new a(21);

        /* JADX INFO: renamed from: F */
        public static final a f461F = new a(22);

        /* JADX INFO: renamed from: G */
        public static final a f462G = new a(23);

        /* JADX INFO: renamed from: H */
        public static final a f463H = new a(24);

        /* JADX INFO: renamed from: I */
        public static final a f464I = new a(25);

        /* JADX INFO: renamed from: J */
        public static final a f465J = new a(26);

        /* JADX INFO: renamed from: K */
        public static final a f466K = new a(27);

        /* JADX INFO: renamed from: L */
        public static final a f467L = new a(28);

        /* JADX INFO: renamed from: M */
        public static final a f468M = new a(29);

        /* JADX INFO: renamed from: N */
        public static final a f469N = new a(30);

        /* JADX INFO: renamed from: O */
        public static final a f470O = new a(31);

        /* JADX INFO: renamed from: P */
        public static final a f471P = new a(32);

        /* JADX INFO: renamed from: Q */
        public static final a f472Q = new a(33);

        /* JADX INFO: renamed from: R */
        public static final a f473R = new a(34);

        /* JADX INFO: renamed from: S */
        public static final a f474S = new a(35);

        /* JADX INFO: renamed from: T */
        public static final a f475T = new a(36);

        /* JADX INFO: renamed from: U */
        public static final a f476U = new a(37);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(0);
            this.f494V = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            switch (this.f494V) {
                case 0:
                    return new ComponentTypeTypeAdapter();
                case 1:
                    return new EmbedTypeTypeAdapter();
                case 2:
                    return new FriendSuggestionReasonTypeAdapter();
                case 3:
                    return new GuildExplicitContentFilterTypeAdapter();
                case 4:
                    return new GuildHubTypeTypeAdapter();
                case 5:
                    return new GuildMaxVideoChannelUsersTypeAdapter();
                case 6:
                    return new GuildRoleSubscriptionBenefitTypeAdapter();
                case 7:
                    return new GuildScheduledEventEntityTypeTypeAdapter();
                case 8:
                    return new GuildScheduledEventStatusTypeAdapter();
                case 9:
                    return new GuildVerificationLevelTypeAdapter();
                case 10:
                    return new LocalizedStringTypeAdapter();
                case 11:
                    return new MessageActivityTypeTypeAdapter();
                case 12:
                    return new NsfwAllowanceTypeAdapter();
                case 13:
                    return new OAuthScopeTypeAdapter();
                case 14:
                    return new PayoutGroupStatusTypeAdapter();
                case 15:
                    return new PayoutGroupTypeAdapter();
                case 16:
                    return new PayoutStatusAdapter();
                case 17:
                    return new PhoneTypeAdapter();
                case 18:
                    return new PremiumTierTypeAdapter();
                case 19:
                    return new PriceTierTypeAdapter();
                case 20:
                    return new ActivityTypeTypeAdapter();
                case 21:
                    return new ReportNodeBottomButtonTypeAdapter();
                case 22:
                    return new ReportNodeChildTypeAdapter();
                case 23:
                    return new ReportNodeElementDataTypeAdapter();
                case 24:
                    return new RequiredActionTypeAdapter();
                case 25:
                    return new AnalyticsSchemaTypeAdapter();
                case 26:
                    return new StageInstancePrivacyLevelTypeAdapter();
                case 27:
                    return new StickerFormatTypeTypeAdapter();
                case 28:
                    return new StickerTypeTypeAdapter();
                case 29:
                    return new TextStyleTypeAdapter();
                case 30:
                    return new UtcDateTimeTypeAdapter();
                case 31:
                    return new ActivityTypeTypeAdapter();
                case 32:
                    return new AllowedInSuggestionsTypeAdapter();
                case 33:
                    return new ApplicationCommandPermissionTypeTypeAdapter();
                case 34:
                    return new CommandTypeAdapter();
                case 35:
                    return new ApplicationStatusTypeAdapter();
                case 36:
                    return new ApplicationTypeAdapter();
                case 37:
                    return new ButtonStyleTypeAdapter();
                default:
                    throw null;
            }
        }
    }

    /* JADX INFO: renamed from: b.a.b.a$b */
    /* JADX INFO: compiled from: TypeAdapterRegistrar.kt */
    public static final class b extends AbstractC12240o implements Function0<ActivityPlatformTypeAdapter> {

        /* JADX INFO: renamed from: j */
        public static final b f495j = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ActivityPlatformTypeAdapter invoke() {
            return new ActivityPlatformTypeAdapter();
        }
    }

    /* JADX INFO: renamed from: a */
    public static final C4901e m147a(C4901e c4901e) {
        C12238m.checkNotNullParameter(c4901e, "$this$registerDiscordApiTypeAdapters");
        for (Map.Entry<Class<? extends Object>, Function0<Object>> entry : f454a.entrySet()) {
            c4901e.m6852b(entry.getKey(), entry.getValue().invoke());
        }
        C12238m.checkNotNullParameter(c4901e, "$this$registerDiscordApiTypeAdapterFactories");
        Iterator<T> it = f455b.iterator();
        while (it.hasNext()) {
            c4901e.f13099e.add((InterfaceC4911o) it.next());
        }
        return c4901e;
    }
}
