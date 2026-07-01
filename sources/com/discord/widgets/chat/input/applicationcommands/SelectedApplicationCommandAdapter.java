package com.discord.widgets.chat.input.applicationcommands;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: SelectedApplicationCommandAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter extends MGRecyclerAdapterSimple<SelectedApplicationCommandItem> {
    private ApplicationCommand currentCommand;
    private ApplicationCommandOption highlightedCommandOption;
    private final Function1<ApplicationCommandOption, Unit> onClickApplicationCommandOption;
    private final Map<String, Integer> paramPositions;
    private RecyclerView$SmoothScroller scroller;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectedApplicationCommandAdapter(RecyclerView recyclerView, Function1<? super ApplicationCommandOption, Unit> function1) {
        super(recyclerView, false);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(function1, "onClickApplicationCommandOption");
        this.onClickApplicationCommandOption = function1;
        this.paramPositions = new LinkedHashMap();
        this.scroller = new SelectedApplicationCommandAdapter$scroller$1(this, getContext());
    }

    public static final /* synthetic */ RecyclerView$SmoothScroller access$getScroller$p(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter) {
        return selectedApplicationCommandAdapter.scroller;
    }

    public static final /* synthetic */ void access$setScroller$p(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter, RecyclerView$SmoothScroller recyclerView$SmoothScroller) {
        selectedApplicationCommandAdapter.scroller = recyclerView$SmoothScroller;
    }

    private final void configureVerified() {
    }

    public final void clear() {
        setData(n.emptyList());
        this.paramPositions.clear();
        this.currentCommand = null;
        this.highlightedCommandOption = null;
    }

    public final void clearParamOptionHighlight() {
        if (getItemCount() == 0) {
            return;
        }
        Map<String, Integer> map = this.paramPositions;
        ApplicationCommandOption applicationCommandOption = this.highlightedCommandOption;
        Integer num = map.get(applicationCommandOption != null ? applicationCommandOption.getName() : null);
        if (num != null) {
            int iIntValue = num.intValue();
            getItem(iIntValue).setHighlighted(false);
            notifyItemChanged(iIntValue);
        }
    }

    public final Function1<ApplicationCommandOption, Unit> getOnClickApplicationCommandOption() {
        return this.onClickApplicationCommandOption;
    }

    public final void highlightOption(ApplicationCommandOption commandOption) {
        Integer num;
        m.checkNotNullParameter(commandOption, "commandOption");
        if (m.areEqual(this.highlightedCommandOption, commandOption)) {
            return;
        }
        clearParamOptionHighlight();
        this.highlightedCommandOption = commandOption;
        if (getItemCount() == 0 || (num = this.paramPositions.get(commandOption.getName())) == null) {
            return;
        }
        int iIntValue = num.intValue();
        this.highlightedCommandOption = commandOption;
        getItem(iIntValue).setHighlighted(true);
        notifyItemChanged(iIntValue);
        getRecycler().post(new SelectedApplicationCommandAdapter$highlightOption$$inlined$let$lambda$1(iIntValue, this, commandOption));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void onParamClicked(ApplicationCommandOption option) {
        m.checkNotNullParameter(option, "option");
        this.onClickApplicationCommandOption.invoke(option);
    }

    public final void setApplicationCommand(ApplicationCommand command, Application application) {
        m.checkNotNullParameter(command, "command");
        m.checkNotNullParameter(application, "application");
        ApplicationCommand applicationCommand = this.currentCommand;
        if (m.areEqual(applicationCommand != null ? applicationCommand.getId() : null, command.getId())) {
            return;
        }
        this.currentCommand = command;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SelectedApplicationCommandItem(application, null, false, false, false, command.getName(), null, 94, null));
        List<ApplicationCommandOption> options = command.getOptions();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : options) {
            if (((ApplicationCommandOption) obj).getRequired()) {
                arrayList2.add(obj);
            }
        }
        int i = 0;
        int i2 = 0;
        for (Object obj2 : arrayList2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                n.throwIndexOverflow();
            }
            ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) obj2;
            this.paramPositions.put(applicationCommandOption.getName(), Integer.valueOf(arrayList.size()));
            arrayList.add(new SelectedApplicationCommandItem(null, applicationCommandOption, false, false, false, null, null, Opcodes.LUSHR, null));
            i2 = i3;
        }
        List<ApplicationCommandOption> options2 = command.getOptions();
        if (!(options2 instanceof Collection) || !options2.isEmpty()) {
            Iterator<T> it = options2.iterator();
            while (it.hasNext()) {
                if ((!((ApplicationCommandOption) it.next()).getRequired()) && (i = i + 1) < 0) {
                    n.throwCountOverflow();
                }
            }
        }
        if (i != 0) {
            arrayList.add(new SelectedApplicationCommandItem(null, null, false, false, false, null, getRecycler().getResources().getString(2131887790), 63, null));
        }
        List<ApplicationCommandOption> options3 = command.getOptions();
        ArrayList<ApplicationCommandOption> arrayList3 = new ArrayList();
        for (Object obj3 : options3) {
            if (!((ApplicationCommandOption) obj3).getRequired()) {
                arrayList3.add(obj3);
            }
        }
        for (ApplicationCommandOption applicationCommandOption2 : arrayList3) {
            this.paramPositions.put(applicationCommandOption2.getName(), Integer.valueOf(arrayList.size()));
            arrayList.add(new SelectedApplicationCommandItem(null, applicationCommandOption2, false, false, false, null, null, Opcodes.LUSHR, null));
        }
        setData(arrayList);
    }

    public final void setVerified(Map<ApplicationCommandOption, Boolean> verifiedInputs, Set<ApplicationCommandOption> showOptionErrorSet) {
        m.checkNotNullParameter(verifiedInputs, "verifiedInputs");
        m.checkNotNullParameter(showOptionErrorSet, "showOptionErrorSet");
        if (getItemCount() == 0) {
            return;
        }
        for (ApplicationCommandOption applicationCommandOption : verifiedInputs.keySet()) {
            Integer num = this.paramPositions.get(applicationCommandOption.getName());
            if (num != null) {
                int iIntValue = num.intValue();
                getItem(iIntValue).setCompleted(m.areEqual(verifiedInputs.get(applicationCommandOption), Boolean.TRUE));
                getItem(iIntValue).setError(showOptionErrorSet.contains(applicationCommandOption));
            }
        }
        configureVerified();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<SelectedApplicationCommandAdapter, SelectedApplicationCommandItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new SelectedAppCommandTitleAdapterItem(this);
        }
        if (viewType == 1) {
            return new SelectedAppCommandOptionAdapterItem(this);
        }
        if (viewType == 2) {
            return new SelectedAppCommandSectionHeadingAdapterItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
