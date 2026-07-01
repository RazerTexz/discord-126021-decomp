package b.a.b;

import com.discord.api.activity.ActivityTypeTypeAdapter;
import com.discord.api.application.ApplicationTypeAdapter;
import com.discord.api.auth.OAuthScopeTypeAdapter;
import com.discord.api.auth.RequiredActionTypeAdapter;
import com.discord.api.botuikit.ButtonStyleTypeAdapter;
import com.discord.api.botuikit.TextStyleTypeAdapter;
import com.discord.api.botuikit.gson.ComponentTypeTypeAdapter;
import com.discord.api.commands.ApplicationCommandPermissionTypeTypeAdapter;
import com.discord.api.commands.CommandTypeAdapter;
import com.discord.api.friendsuggestions.AllowedInSuggestionsTypeAdapter;
import com.discord.api.friendsuggestions.FriendSuggestionReasonTypeAdapter;
import com.discord.api.guild.GuildExplicitContentFilterTypeAdapter;
import com.discord.api.guild.GuildHubTypeTypeAdapter;
import com.discord.api.guild.GuildMaxVideoChannelUsersTypeAdapter;
import com.discord.api.guild.GuildVerificationLevelTypeAdapter;
import com.discord.api.guildjoinrequest.ApplicationStatusTypeAdapter;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitTypeAdapter;
import com.discord.api.guildrolesubscription.PayoutGroupStatusTypeAdapter;
import com.discord.api.guildrolesubscription.PayoutGroupTypeAdapter;
import com.discord.api.guildrolesubscription.PayoutStatusAdapter;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityTypeTypeAdapter;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatusTypeAdapter;
import com.discord.api.localizedstring.LocalizedStringTypeAdapter;
import com.discord.api.message.activity.MessageActivityTypeTypeAdapter;
import com.discord.api.message.embed.EmbedTypeTypeAdapter;
import com.discord.api.premium.PremiumTierTypeAdapter;
import com.discord.api.premium.PriceTierTypeAdapter;
import com.discord.api.report.ReportNodeBottomButtonTypeAdapter;
import com.discord.api.report.ReportNodeChildTypeAdapter;
import com.discord.api.report.ReportNodeElementDataTypeAdapter;
import com.discord.api.science.AnalyticsSchemaTypeAdapter;
import com.discord.api.stageinstance.StageInstancePrivacyLevelTypeAdapter;
import com.discord.api.sticker.StickerFormatTypeTypeAdapter;
import com.discord.api.sticker.StickerTypeTypeAdapter;
import com.discord.api.user.NsfwAllowanceTypeAdapter;
import com.discord.api.user.PhoneTypeAdapter;
import com.discord.api.utcdatetime.UtcDateTimeTypeAdapter;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class a$a extends o implements Function0<Object> {
    public final /* synthetic */ int V;
    public static final a$a j = new a$a(0);
    public static final a$a k = new a$a(1);
    public static final a$a l = new a$a(2);
    public static final a$a m = new a$a(3);
    public static final a$a n = new a$a(4);
    public static final a$a o = new a$a(5);
    public static final a$a p = new a$a(6);
    public static final a$a q = new a$a(7);
    public static final a$a r = new a$a(8);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a$a f52s = new a$a(9);
    public static final a$a t = new a$a(10);
    public static final a$a u = new a$a(11);
    public static final a$a v = new a$a(12);
    public static final a$a w = new a$a(13);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a$a f53x = new a$a(14);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a$a f54y = new a$a(15);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a$a f55z = new a$a(16);
    public static final a$a A = new a$a(17);
    public static final a$a B = new a$a(18);
    public static final a$a C = new a$a(19);
    public static final a$a D = new a$a(20);
    public static final a$a E = new a$a(21);
    public static final a$a F = new a$a(22);
    public static final a$a G = new a$a(23);
    public static final a$a H = new a$a(24);
    public static final a$a I = new a$a(25);
    public static final a$a J = new a$a(26);
    public static final a$a K = new a$a(27);
    public static final a$a L = new a$a(28);
    public static final a$a M = new a$a(29);
    public static final a$a N = new a$a(30);
    public static final a$a O = new a$a(31);
    public static final a$a P = new a$a(32);
    public static final a$a Q = new a$a(33);
    public static final a$a R = new a$a(34);
    public static final a$a S = new a$a(35);
    public static final a$a T = new a$a(36);
    public static final a$a U = new a$a(37);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$a(int i) {
        super(0);
        this.V = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.V) {
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
