package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildVideoAtCapacityDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m$b extends d0.z.d.k implements Function1<View, b.a.i.z> {
    public static final m$b j = new m$b();

    public m$b() {
        super(1, b.a.i.z.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildVideoAtCapacityBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public b.a.i.z invoke(View view) {
        View view2 = view;
        d0.z.d.m.checkNotNullParameter(view2, "p1");
        int i = R$id.guild_video_at_capacity_confirm;
        MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.guild_video_at_capacity_confirm);
        if (materialButton != null) {
            i = R$id.notice_header_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R$id.notice_header_container);
            if (linearLayout != null) {
                return new b.a.i.z((LinearLayout) view2, materialButton, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
