package com.discord.views.experiments;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import b.a.i.ViewExperimentOverrideBinding;
import b.a.i.ViewSimpleSpinnerDropdownItemBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: ExperimentOverrideView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExperimentOverrideView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewExperimentOverrideBinding binding;

    /* JADX INFO: compiled from: ExperimentOverrideView.kt */
    public static final class a extends ArrayAdapter<b> {
        public final List<b> j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, List<b> list) {
            super(context, R.layout.view_simple_spinner_dropdown_item, list);
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(list, "items");
            this.j = list;
        }

        public final View a(int i, View view) {
            View view2 = view;
            if (view == null) {
                View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_simple_spinner_dropdown_item, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                TextView textView = (TextView) viewInflate;
                Intrinsics3.checkNotNullExpressionValue(new ViewSimpleSpinnerDropdownItemBinding(textView), "ViewSimpleSpinnerDropdow…om(context), null, false)");
                Intrinsics3.checkNotNullExpressionValue(textView, "ViewSimpleSpinnerDropdow…ntext), null, false).root");
                view2 = textView;
            }
            ((TextView) view2).setText(this.j.get(i).f2842b);
            return view2;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.j.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            Intrinsics3.checkNotNullParameter(viewGroup, "parent");
            return a(i, view);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public Object getItem(int i) {
            return this.j.get(i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            Integer num = this.j.get(i).a;
            if (num != null) {
                return num.intValue();
            }
            return -1L;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Intrinsics3.checkNotNullParameter(viewGroup, "parent");
            return a(i, view);
        }
    }

    /* JADX INFO: compiled from: ExperimentOverrideView.kt */
    public static final class b {
        public final Integer a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2842b;

        public b(Integer num, String str) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.a = num;
            this.f2842b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics3.areEqual(this.a, bVar.a) && Intrinsics3.areEqual(this.f2842b, bVar.f2842b);
        }

        public int hashCode() {
            Integer num = this.a;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            String str = this.f2842b;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SpinnerItem(bucket=");
            sbU.append(this.a);
            sbU.append(", text=");
            return outline.J(sbU, this.f2842b, ")");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperimentOverrideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_experiment_override, this);
        int i = R.id.experiment_override_bucket_descriptions;
        TextView textView = (TextView) findViewById(R.id.experiment_override_bucket_descriptions);
        if (textView != null) {
            i = R.id.experiment_override_buckets_spinner;
            Spinner spinner = (Spinner) findViewById(R.id.experiment_override_buckets_spinner);
            if (spinner != null) {
                i = R.id.experiment_override_buckets_spinner_container;
                MaterialCardView materialCardView = (MaterialCardView) findViewById(R.id.experiment_override_buckets_spinner_container);
                if (materialCardView != null) {
                    i = R.id.experiment_override_clear;
                    TextView textView2 = (TextView) findViewById(R.id.experiment_override_clear);
                    if (textView2 != null) {
                        i = R.id.experiment_override_experiment_api_name;
                        TextView textView3 = (TextView) findViewById(R.id.experiment_override_experiment_api_name);
                        if (textView3 != null) {
                            i = R.id.experiment_override_experiment_name;
                            TextView textView4 = (TextView) findViewById(R.id.experiment_override_experiment_name);
                            if (textView4 != null) {
                                ViewExperimentOverrideBinding viewExperimentOverrideBinding = new ViewExperimentOverrideBinding(this, textView, spinner, materialCardView, textView2, textView3, textView4);
                                Intrinsics3.checkNotNullExpressionValue(viewExperimentOverrideBinding, "ViewExperimentOverrideBi…ater.from(context), this)");
                                this.binding = viewExperimentOverrideBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}
