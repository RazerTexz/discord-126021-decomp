package com.discord.widgets.channels;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import com.discord.C5419R;
import com.discord.databinding.UserAkaViewBinding;
import com.discord.models.member.GuildMember;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.views.PileView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UserAkaView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAkaView extends ConstraintLayout {
    private final UserAkaViewBinding binding;
    private List<GuildMember> guildMembers;
    private final StringBuilder nicknameStringBuilder;
    private List<PileView.C7089c> pileItems;

    public UserAkaView(Context context) {
        this(context, null, 0, 6, null);
    }

    public UserAkaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ UserAkaView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void configure(final List<GuildMember> guildMembers) {
        C12238m.checkNotNullParameter(guildMembers, "guildMembers");
        this.guildMembers = guildMembers;
        float dimension = getResources().getDimension(C5419R.dimen.aka_avatar_width);
        ArrayList arrayList = new ArrayList();
        for (Object obj : guildMembers) {
            if (((GuildMember) obj).hasAvatar()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String forGuildMember$default = IconUtils.getForGuildMember$default(IconUtils.INSTANCE, (GuildMember) it.next(), Integer.valueOf((int) dimension), false, 4, null);
            if (forGuildMember$default != null) {
                arrayList2.add(forGuildMember$default);
            }
        }
        ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(new PileView.C7089c(new UserAkaView$configure$1$1((String) it2.next()), null));
        }
        this.pileItems = arrayList3;
        this.binding.f15323c.setItems(arrayList3);
        C12238m.checkNotNullExpressionValue(OneShotPreDrawListener.add(this, new Runnable() { // from class: com.discord.widgets.channels.UserAkaView$configure$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                Number numberValueOf;
                List list = guildMembers;
                ArrayList arrayList4 = new ArrayList();
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    String nick = ((GuildMember) it3.next()).getNick();
                    if (nick != null) {
                        arrayList4.add(nick);
                    }
                }
                ArrayList arrayList5 = new ArrayList();
                for (Object obj2 : arrayList4) {
                    if (!C12103t.isBlank((String) obj2)) {
                        arrayList5.add(obj2);
                    }
                }
                if (this.getPileItems().isEmpty()) {
                    TextView textView = this.binding.f15325e;
                    C12238m.checkNotNullExpressionValue(textView, "binding.spaceForMeasuring");
                    numberValueOf = Float.valueOf(textView.getMeasuredWidth());
                } else {
                    numberValueOf = Integer.valueOf(DimenUtils.dpToPixels(8));
                }
                TextView textView2 = this.binding.f15322b;
                C12238m.checkNotNullExpressionValue(textView2, "binding.akaText");
                float measuredWidth = textView2.getMeasuredWidth();
                PileView pileView = this.binding.f15323c;
                C12238m.checkNotNullExpressionValue(pileView, "binding.avatarsPileView");
                float fFloatValue = numberValueOf.floatValue() + measuredWidth + pileView.getMeasuredWidth();
                SpannableString spannableString = new SpannableString(C12163u.joinToString$default(arrayList5, ", ", null, null, 0, null, null, 62, null));
                spannableString.setSpan(new LeadingMarginSpan.Standard((int) fFloatValue, 0), 0, spannableString.length(), 33);
                TextView textView3 = this.binding.f15324d;
                C12238m.checkNotNullExpressionValue(textView3, "binding.nicknames");
                textView3.setText(spannableString);
                TextView textView4 = this.binding.f15324d;
                C12238m.checkNotNullExpressionValue(textView4, "binding.nicknames");
                textView4.setVisibility(arrayList5.isEmpty() ^ true ? 0 : 8);
            }
        }), "View.doOnPreDraw(\n    crossinline action: (view: View) -> Unit\n): OneShotPreDrawListener = OneShotPreDrawListener.add(this) { action(this) }");
    }

    public final List<GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final StringBuilder getNicknameStringBuilder() {
        return this.nicknameStringBuilder;
    }

    public final List<PileView.C7089c> getPileItems() {
        return this.pileItems;
    }

    public final void setGuildMembers(List<GuildMember> list) {
        C12238m.checkNotNullParameter(list, "<set-?>");
        this.guildMembers = list;
    }

    public final void setPileItems(List<PileView.C7089c> list) {
        C12238m.checkNotNullParameter(list, "<set-?>");
        this.pileItems = list;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAkaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        this.guildMembers = C12147n.emptyList();
        this.pileItems = C12147n.emptyList();
        this.nicknameStringBuilder = new StringBuilder();
        LayoutInflater.from(context).inflate(C5419R.layout.user_aka_view, this);
        int i2 = C5419R.id.aka_text;
        TextView textView = (TextView) findViewById(C5419R.id.aka_text);
        if (textView != null) {
            i2 = C5419R.id.avatars_pile_view;
            PileView pileView = (PileView) findViewById(C5419R.id.avatars_pile_view);
            if (pileView != null) {
                i2 = C5419R.id.nicknames;
                TextView textView2 = (TextView) findViewById(C5419R.id.nicknames);
                if (textView2 != null) {
                    i2 = C5419R.id.space_for_measuring;
                    TextView textView3 = (TextView) findViewById(C5419R.id.space_for_measuring);
                    if (textView3 != null) {
                        UserAkaViewBinding userAkaViewBinding = new UserAkaViewBinding(this, textView, pileView, textView2, textView3);
                        C12238m.checkNotNullExpressionValue(userAkaViewBinding, "UserAkaViewBinding.infla…ater.from(context), this)");
                        this.binding = userAkaViewBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
