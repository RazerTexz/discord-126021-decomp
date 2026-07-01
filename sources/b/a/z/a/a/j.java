package b.a.z.a.a;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddMember$Model;
import java.util.List;
import rx.functions.Func4;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j implements Func4 {
    public final /* synthetic */ Channel a;

    public /* synthetic */ j(Channel channel) {
        this.a = channel;
    }

    @Override // rx.functions.Func4
    public final Object call(Object obj, Object obj2, Object obj3, Object obj4) {
        return WidgetChannelSettingsPermissionsAddMember$Model.lambda$null$1(this.a, (MeUser) obj, (Guild) obj2, (Long) obj3, (List) obj4);
    }
}
