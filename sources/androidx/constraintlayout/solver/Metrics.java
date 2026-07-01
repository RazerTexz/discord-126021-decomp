package androidx.constraintlayout.solver;

import b.d.b.a.outline;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Metrics {
    public long additionalMeasures;
    public long barrierConnectionResolved;
    public long bfs;
    public long centerConnectionResolved;
    public long chainConnectionResolved;
    public long constraints;
    public long determineGroups;
    public long errors;
    public long extravariables;
    public long fullySolved;
    public long graphOptimizer;
    public long graphSolved;
    public long grouping;
    public long infeasibleDetermineGroups;
    public long iterations;
    public long lastTableSize;
    public long layouts;
    public long linearSolved;
    public long matchConnectionResolved;
    public long maxRows;
    public long maxTableSize;
    public long maxVariables;
    public long measuredMatchWidgets;
    public long measuredWidgets;
    public long measures;
    public long measuresLayoutDuration;
    public long measuresWidgetsDuration;
    public long measuresWrap;
    public long measuresWrapInfeasible;
    public long minimize;
    public long minimizeGoal;
    public long nonresolvedWidgets;
    public long oldresolvedWidgets;
    public long optimize;
    public long pivots;
    public ArrayList<String> problematicLayouts = new ArrayList<>();
    public long resolutions;
    public long resolvedWidgets;
    public long simpleconstraints;
    public long slackvariables;
    public long tableSizeIncrease;
    public long variables;
    public long widgets;

    public void reset() {
        this.measures = 0L;
        this.widgets = 0L;
        this.additionalMeasures = 0L;
        this.resolutions = 0L;
        this.tableSizeIncrease = 0L;
        this.maxTableSize = 0L;
        this.lastTableSize = 0L;
        this.maxVariables = 0L;
        this.maxRows = 0L;
        this.minimize = 0L;
        this.minimizeGoal = 0L;
        this.constraints = 0L;
        this.simpleconstraints = 0L;
        this.optimize = 0L;
        this.iterations = 0L;
        this.pivots = 0L;
        this.bfs = 0L;
        this.variables = 0L;
        this.errors = 0L;
        this.slackvariables = 0L;
        this.extravariables = 0L;
        this.fullySolved = 0L;
        this.graphOptimizer = 0L;
        this.graphSolved = 0L;
        this.resolvedWidgets = 0L;
        this.oldresolvedWidgets = 0L;
        this.nonresolvedWidgets = 0L;
        this.centerConnectionResolved = 0L;
        this.matchConnectionResolved = 0L;
        this.chainConnectionResolved = 0L;
        this.barrierConnectionResolved = 0L;
        this.problematicLayouts.clear();
    }

    public String toString() {
        StringBuilder sbU = outline.U("\n*** Metrics ***\nmeasures: ");
        sbU.append(this.measures);
        sbU.append("\nmeasuresWrap: ");
        sbU.append(this.measuresWrap);
        sbU.append("\nmeasuresWrapInfeasible: ");
        sbU.append(this.measuresWrapInfeasible);
        sbU.append("\ndetermineGroups: ");
        sbU.append(this.determineGroups);
        sbU.append("\ninfeasibleDetermineGroups: ");
        sbU.append(this.infeasibleDetermineGroups);
        sbU.append("\ngraphOptimizer: ");
        sbU.append(this.graphOptimizer);
        sbU.append("\nwidgets: ");
        sbU.append(this.widgets);
        sbU.append("\ngraphSolved: ");
        sbU.append(this.graphSolved);
        sbU.append("\nlinearSolved: ");
        return outline.C(sbU, this.linearSolved, "\n");
    }
}
