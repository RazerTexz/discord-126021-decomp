package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import b.d.b.a.a;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DependencyGraph {
    private static final boolean USE_GROUPS = true;
    private ConstraintWidgetContainer container;
    private ConstraintWidgetContainer mContainer;
    private boolean mNeedBuildGraph = true;
    private boolean mNeedRedoMeasures = true;
    private ArrayList<WidgetRun> mRuns = new ArrayList<>();
    private ArrayList<RunGroup> runGroups = new ArrayList<>();
    private BasicMeasure$Measurer mMeasurer = null;
    private BasicMeasure$Measure mMeasure = new BasicMeasure$Measure();
    public ArrayList<RunGroup> mGroups = new ArrayList<>();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.container = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    private void applyGroup(DependencyNode dependencyNode, int i, int i2, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun.runGroup == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            if (widgetRun == constraintWidgetContainer.horizontalRun || widgetRun == constraintWidgetContainer.verticalRun) {
                return;
            }
            if (runGroup == null) {
                runGroup = new RunGroup(widgetRun, i2);
                arrayList.add(runGroup);
            }
            widgetRun.runGroup = runGroup;
            runGroup.add(widgetRun);
            for (Dependency dependency : widgetRun.start.dependencies) {
                if (dependency instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency, i, 0, dependencyNode2, arrayList, runGroup);
                }
            }
            for (Dependency dependency2 : widgetRun.end.dependencies) {
                if (dependency2 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency2, i, 1, dependencyNode2, arrayList, runGroup);
                }
            }
            if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                    if (dependency3 instanceof DependencyNode) {
                        applyGroup((DependencyNode) dependency3, i, 2, dependencyNode2, arrayList, runGroup);
                    }
                }
            }
            for (DependencyNode dependencyNode3 : widgetRun.start.targets) {
                if (dependencyNode3 == dependencyNode2) {
                    runGroup.dual = true;
                }
                applyGroup(dependencyNode3, i, 0, dependencyNode2, arrayList, runGroup);
            }
            for (DependencyNode dependencyNode4 : widgetRun.end.targets) {
                if (dependencyNode4 == dependencyNode2) {
                    runGroup.dual = true;
                }
                applyGroup(dependencyNode4, i, 1, dependencyNode2, arrayList, runGroup);
            }
            if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                Iterator<DependencyNode> it = ((VerticalWidgetRun) widgetRun).baseline.targets.iterator();
                while (it.hasNext()) {
                    applyGroup(it.next(), i, 2, dependencyNode2, arrayList, runGroup);
                }
            }
        }
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        int width;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        int height;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4;
        for (ConstraintWidget constraintWidget : constraintWidgetContainer.mChildren) {
            ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5 = constraintWidget$DimensionBehaviourArr[0];
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour6 = constraintWidget$DimensionBehaviourArr[1];
            if (constraintWidget.getVisibility() == 8) {
                constraintWidget.measured = true;
            } else {
                if (constraintWidget.mMatchConstraintPercentWidth < 1.0f && constraintWidget$DimensionBehaviour5 == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.mMatchConstraintDefaultWidth = 2;
                }
                if (constraintWidget.mMatchConstraintPercentHeight < 1.0f && constraintWidget$DimensionBehaviour6 == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.mMatchConstraintDefaultHeight = 2;
                }
                if (constraintWidget.getDimensionRatio() > 0.0f) {
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour7 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                    if (constraintWidget$DimensionBehaviour5 == constraintWidget$DimensionBehaviour7 && (constraintWidget$DimensionBehaviour6 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT || constraintWidget$DimensionBehaviour6 == ConstraintWidget$DimensionBehaviour.FIXED)) {
                        constraintWidget.mMatchConstraintDefaultWidth = 3;
                    } else if (constraintWidget$DimensionBehaviour6 == constraintWidget$DimensionBehaviour7 && (constraintWidget$DimensionBehaviour5 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT || constraintWidget$DimensionBehaviour5 == ConstraintWidget$DimensionBehaviour.FIXED)) {
                        constraintWidget.mMatchConstraintDefaultHeight = 3;
                    } else if (constraintWidget$DimensionBehaviour5 == constraintWidget$DimensionBehaviour7 && constraintWidget$DimensionBehaviour6 == constraintWidget$DimensionBehaviour7) {
                        if (constraintWidget.mMatchConstraintDefaultWidth == 0) {
                            constraintWidget.mMatchConstraintDefaultWidth = 3;
                        }
                        if (constraintWidget.mMatchConstraintDefaultHeight == 0) {
                            constraintWidget.mMatchConstraintDefaultHeight = 3;
                        }
                    }
                }
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour8 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                if (constraintWidget$DimensionBehaviour5 == constraintWidget$DimensionBehaviour8 && constraintWidget.mMatchConstraintDefaultWidth == 1 && (constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null)) {
                    constraintWidget$DimensionBehaviour5 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour9 = constraintWidget$DimensionBehaviour5;
                if (constraintWidget$DimensionBehaviour6 == constraintWidget$DimensionBehaviour8 && constraintWidget.mMatchConstraintDefaultHeight == 1 && (constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget == null)) {
                    constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour10 = constraintWidget$DimensionBehaviour6;
                HorizontalWidgetRun horizontalWidgetRun = constraintWidget.horizontalRun;
                horizontalWidgetRun.dimensionBehavior = constraintWidget$DimensionBehaviour9;
                int i = constraintWidget.mMatchConstraintDefaultWidth;
                horizontalWidgetRun.matchConstraintsType = i;
                VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
                verticalWidgetRun.dimensionBehavior = constraintWidget$DimensionBehaviour10;
                int i2 = constraintWidget.mMatchConstraintDefaultHeight;
                verticalWidgetRun.matchConstraintsType = i2;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour11 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
                if ((constraintWidget$DimensionBehaviour9 == constraintWidget$DimensionBehaviour11 || constraintWidget$DimensionBehaviour9 == ConstraintWidget$DimensionBehaviour.FIXED || constraintWidget$DimensionBehaviour9 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) && (constraintWidget$DimensionBehaviour10 == constraintWidget$DimensionBehaviour11 || constraintWidget$DimensionBehaviour10 == ConstraintWidget$DimensionBehaviour.FIXED || constraintWidget$DimensionBehaviour10 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
                    int width2 = constraintWidget.getWidth();
                    if (constraintWidget$DimensionBehaviour9 == constraintWidget$DimensionBehaviour11) {
                        width = (constraintWidgetContainer.getWidth() - constraintWidget.mLeft.mMargin) - constraintWidget.mRight.mMargin;
                        constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
                    } else {
                        width = width2;
                        constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviour9;
                    }
                    int height2 = constraintWidget.getHeight();
                    if (constraintWidget$DimensionBehaviour10 == constraintWidget$DimensionBehaviour11) {
                        height = (constraintWidgetContainer.getHeight() - constraintWidget.mTop.mMargin) - constraintWidget.mBottom.mMargin;
                        constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.FIXED;
                    } else {
                        height = height2;
                        constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviour10;
                    }
                    measure(constraintWidget, constraintWidget$DimensionBehaviour, width, constraintWidget$DimensionBehaviour2, height);
                    constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                    constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                    constraintWidget.measured = true;
                } else {
                    if (constraintWidget$DimensionBehaviour9 == constraintWidget$DimensionBehaviour8 && (constraintWidget$DimensionBehaviour10 == (constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || constraintWidget$DimensionBehaviour10 == ConstraintWidget$DimensionBehaviour.FIXED)) {
                        if (i == 3) {
                            if (constraintWidget$DimensionBehaviour10 == constraintWidget$DimensionBehaviour4) {
                                measure(constraintWidget, constraintWidget$DimensionBehaviour4, 0, constraintWidget$DimensionBehaviour4, 0);
                            }
                            int height3 = constraintWidget.getHeight();
                            int i3 = (int) ((height3 * constraintWidget.mDimensionRatio) + 0.5f);
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour12 = ConstraintWidget$DimensionBehaviour.FIXED;
                            measure(constraintWidget, constraintWidget$DimensionBehaviour12, i3, constraintWidget$DimensionBehaviour12, height3);
                            constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                            constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                            constraintWidget.measured = true;
                        } else if (i == 1) {
                            measure(constraintWidget, constraintWidget$DimensionBehaviour4, 0, constraintWidget$DimensionBehaviour10, 0);
                            constraintWidget.horizontalRun.dimension.wrapValue = constraintWidget.getWidth();
                        } else if (i == 2) {
                            ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr2 = constraintWidgetContainer.mListDimensionBehaviors;
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour13 = constraintWidget$DimensionBehaviourArr2[0];
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour14 = ConstraintWidget$DimensionBehaviour.FIXED;
                            if (constraintWidget$DimensionBehaviour13 == constraintWidget$DimensionBehaviour14 || constraintWidget$DimensionBehaviourArr2[0] == constraintWidget$DimensionBehaviour11) {
                                measure(constraintWidget, constraintWidget$DimensionBehaviour14, (int) ((constraintWidget.mMatchConstraintPercentWidth * constraintWidgetContainer.getWidth()) + 0.5f), constraintWidget$DimensionBehaviour10, constraintWidget.getHeight());
                                constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                                constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                                constraintWidget.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
                            if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                                measure(constraintWidget, constraintWidget$DimensionBehaviour4, 0, constraintWidget$DimensionBehaviour10, 0);
                                constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                                constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                                constraintWidget.measured = true;
                            }
                        }
                    }
                    if (constraintWidget$DimensionBehaviour10 == constraintWidget$DimensionBehaviour8 && (constraintWidget$DimensionBehaviour9 == (constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || constraintWidget$DimensionBehaviour9 == ConstraintWidget$DimensionBehaviour.FIXED)) {
                        if (i2 == 3) {
                            if (constraintWidget$DimensionBehaviour9 == constraintWidget$DimensionBehaviour3) {
                                measure(constraintWidget, constraintWidget$DimensionBehaviour3, 0, constraintWidget$DimensionBehaviour3, 0);
                            }
                            int width3 = constraintWidget.getWidth();
                            float f = constraintWidget.mDimensionRatio;
                            if (constraintWidget.getDimensionRatioSide() == -1) {
                                f = 1.0f / f;
                            }
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour15 = ConstraintWidget$DimensionBehaviour.FIXED;
                            measure(constraintWidget, constraintWidget$DimensionBehaviour15, width3, constraintWidget$DimensionBehaviour15, (int) ((width3 * f) + 0.5f));
                            constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                            constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                            constraintWidget.measured = true;
                        } else if (i2 == 1) {
                            measure(constraintWidget, constraintWidget$DimensionBehaviour9, 0, constraintWidget$DimensionBehaviour3, 0);
                            constraintWidget.verticalRun.dimension.wrapValue = constraintWidget.getHeight();
                        } else if (i2 == 2) {
                            ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr3 = constraintWidgetContainer.mListDimensionBehaviors;
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour16 = constraintWidget$DimensionBehaviourArr3[1];
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour17 = ConstraintWidget$DimensionBehaviour.FIXED;
                            if (constraintWidget$DimensionBehaviour16 == constraintWidget$DimensionBehaviour17 || constraintWidget$DimensionBehaviourArr3[1] == constraintWidget$DimensionBehaviour11) {
                                measure(constraintWidget, constraintWidget$DimensionBehaviour9, constraintWidget.getWidth(), constraintWidget$DimensionBehaviour17, (int) ((constraintWidget.mMatchConstraintPercentHeight * constraintWidgetContainer.getHeight()) + 0.5f));
                                constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                                constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                                constraintWidget.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.mListAnchors;
                            if (constraintAnchorArr2[2].mTarget == null || constraintAnchorArr2[3].mTarget == null) {
                                measure(constraintWidget, constraintWidget$DimensionBehaviour3, 0, constraintWidget$DimensionBehaviour10, 0);
                                constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                                constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                                constraintWidget.measured = true;
                            }
                        }
                    }
                    if (constraintWidget$DimensionBehaviour9 == constraintWidget$DimensionBehaviour8 && constraintWidget$DimensionBehaviour10 == constraintWidget$DimensionBehaviour8) {
                        if (i == 1 || i2 == 1) {
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour18 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                            measure(constraintWidget, constraintWidget$DimensionBehaviour18, 0, constraintWidget$DimensionBehaviour18, 0);
                            constraintWidget.horizontalRun.dimension.wrapValue = constraintWidget.getWidth();
                            constraintWidget.verticalRun.dimension.wrapValue = constraintWidget.getHeight();
                        } else if (i2 == 2 && i == 2) {
                            ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr4 = constraintWidgetContainer.mListDimensionBehaviors;
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour19 = constraintWidget$DimensionBehaviourArr4[0];
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour20 = ConstraintWidget$DimensionBehaviour.FIXED;
                            if (constraintWidget$DimensionBehaviour19 == constraintWidget$DimensionBehaviour20 || constraintWidget$DimensionBehaviourArr4[0] == constraintWidget$DimensionBehaviour20) {
                                if (constraintWidget$DimensionBehaviourArr4[1] == constraintWidget$DimensionBehaviour20 || constraintWidget$DimensionBehaviourArr4[1] == constraintWidget$DimensionBehaviour20) {
                                    measure(constraintWidget, constraintWidget$DimensionBehaviour20, (int) ((constraintWidget.mMatchConstraintPercentWidth * constraintWidgetContainer.getWidth()) + 0.5f), constraintWidget$DimensionBehaviour20, (int) ((constraintWidget.mMatchConstraintPercentHeight * constraintWidgetContainer.getHeight()) + 0.5f));
                                    constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                                    constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                                    constraintWidget.measured = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        int size = this.mGroups.size();
        long jMax = 0;
        for (int i2 = 0; i2 < size; i2++) {
            jMax = Math.max(jMax, this.mGroups.get(i2).computeWrapSize(constraintWidgetContainer, i));
        }
        return (int) jMax;
    }

    private void displayGraph() {
        Iterator<WidgetRun> it = this.mRuns.iterator();
        String strGenerateDisplayGraph = "digraph {\n";
        while (it.hasNext()) {
            strGenerateDisplayGraph = generateDisplayGraph(it.next(), strGenerateDisplayGraph);
        }
        String strW = a.w(strGenerateDisplayGraph, "\n}\n");
        System.out.println("content:<<\n" + strW + "\n>>");
    }

    private void findGroup(WidgetRun widgetRun, int i, ArrayList<RunGroup> arrayList) {
        for (Dependency dependency : widgetRun.start.dependencies) {
            if (dependency instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency, i, 0, widgetRun.end, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency).start, i, 0, widgetRun.end, arrayList, null);
            }
        }
        for (Dependency dependency2 : widgetRun.end.dependencies) {
            if (dependency2 instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency2, i, 1, widgetRun.start, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency2).end, i, 1, widgetRun.start, arrayList, null);
            }
        }
        if (i == 1) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                if (dependency3 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    private String generateChainDisplayGraph(ChainRun chainRun, String str) {
        int i = chainRun.orientation;
        StringBuilder sbU = a.U("cluster_");
        sbU.append(chainRun.widget.getDebugName());
        String string = sbU.toString();
        String strY = a.y("subgraph ", i == 0 ? a.w(string, "_h") : a.w(string, "_v"), " {\n");
        String strGenerateDisplayGraph = "";
        for (WidgetRun widgetRun : chainRun.widgets) {
            String debugName = widgetRun.widget.getDebugName();
            strY = a.y(strY, i == 0 ? a.w(debugName, "_HORIZONTAL") : a.w(debugName, "_VERTICAL"), ";\n");
            strGenerateDisplayGraph = generateDisplayGraph(widgetRun, strGenerateDisplayGraph);
        }
        return a.y(str, strGenerateDisplayGraph, a.w(strY, "}\n"));
    }

    private String generateDisplayGraph(WidgetRun widgetRun, String str) {
        boolean z2;
        DependencyNode dependencyNode = widgetRun.start;
        DependencyNode dependencyNode2 = widgetRun.end;
        if (!(widgetRun instanceof HelperReferences) && dependencyNode.dependencies.isEmpty() && (dependencyNode2.dependencies.isEmpty() && dependencyNode.targets.isEmpty()) && dependencyNode2.targets.isEmpty()) {
            return str;
        }
        StringBuilder sbU = a.U(str);
        sbU.append(nodeDefinition(widgetRun));
        String string = sbU.toString();
        boolean zIsCenteredConnection = isCenteredConnection(dependencyNode, dependencyNode2);
        String strGenerateDisplayNode = generateDisplayNode(dependencyNode2, zIsCenteredConnection, generateDisplayNode(dependencyNode, zIsCenteredConnection, string));
        boolean z3 = widgetRun instanceof VerticalWidgetRun;
        if (z3) {
            strGenerateDisplayNode = generateDisplayNode(((VerticalWidgetRun) widgetRun).baseline, zIsCenteredConnection, strGenerateDisplayNode);
        }
        if ((widgetRun instanceof HorizontalWidgetRun) || (((z2 = widgetRun instanceof ChainRun)) && ((ChainRun) widgetRun).orientation == 0)) {
            ConstraintWidget$DimensionBehaviour horizontalDimensionBehaviour = widgetRun.widget.getHorizontalDimensionBehaviour();
            if (horizontalDimensionBehaviour == ConstraintWidget$DimensionBehaviour.FIXED || horizontalDimensionBehaviour == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                    StringBuilder sbU2 = a.U("\n");
                    sbU2.append(dependencyNode2.name());
                    sbU2.append(" -> ");
                    sbU2.append(dependencyNode.name());
                    sbU2.append("\n");
                    strGenerateDisplayNode = a.w(strGenerateDisplayNode, sbU2.toString());
                } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                    StringBuilder sbU3 = a.U("\n");
                    sbU3.append(dependencyNode.name());
                    sbU3.append(" -> ");
                    sbU3.append(dependencyNode2.name());
                    sbU3.append("\n");
                    strGenerateDisplayNode = a.w(strGenerateDisplayNode, sbU3.toString());
                }
            } else if (horizontalDimensionBehaviour == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.widget.getDimensionRatio() > 0.0f) {
                widgetRun.widget.getDebugName();
            }
        } else if (z3 || (z2 && ((ChainRun) widgetRun).orientation == 1)) {
            ConstraintWidget$DimensionBehaviour verticalDimensionBehaviour = widgetRun.widget.getVerticalDimensionBehaviour();
            if (verticalDimensionBehaviour == ConstraintWidget$DimensionBehaviour.FIXED || verticalDimensionBehaviour == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                    StringBuilder sbU4 = a.U("\n");
                    sbU4.append(dependencyNode2.name());
                    sbU4.append(" -> ");
                    sbU4.append(dependencyNode.name());
                    sbU4.append("\n");
                    strGenerateDisplayNode = a.w(strGenerateDisplayNode, sbU4.toString());
                } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                    StringBuilder sbU5 = a.U("\n");
                    sbU5.append(dependencyNode.name());
                    sbU5.append(" -> ");
                    sbU5.append(dependencyNode2.name());
                    sbU5.append("\n");
                    strGenerateDisplayNode = a.w(strGenerateDisplayNode, sbU5.toString());
                }
            } else if (verticalDimensionBehaviour == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.widget.getDimensionRatio() > 0.0f) {
                widgetRun.widget.getDebugName();
            }
        }
        return widgetRun instanceof ChainRun ? generateChainDisplayGraph((ChainRun) widgetRun, strGenerateDisplayNode) : strGenerateDisplayNode;
    }

    private String generateDisplayNode(DependencyNode dependencyNode, boolean z2, String str) {
        for (DependencyNode dependencyNode2 : dependencyNode.targets) {
            StringBuilder sbU = a.U("\n");
            sbU.append(dependencyNode.name());
            StringBuilder sbX = a.X(sbU.toString(), " -> ");
            sbX.append(dependencyNode2.name());
            String string = sbX.toString();
            if (dependencyNode.margin > 0 || z2 || (dependencyNode.run instanceof HelperReferences)) {
                String strW = a.w(string, "[");
                if (dependencyNode.margin > 0) {
                    strW = a.B(a.X(strW, "label=\""), dependencyNode.margin, "\"");
                    if (z2) {
                        strW = a.w(strW, ",");
                    }
                }
                if (z2) {
                    strW = a.w(strW, " style=dashed ");
                }
                if (dependencyNode.run instanceof HelperReferences) {
                    strW = a.w(strW, " style=bold,color=gray ");
                }
                string = a.w(strW, "]");
            }
            str = a.w(str, a.w(string, "\n"));
        }
        return str;
    }

    private boolean isCenteredConnection(DependencyNode dependencyNode, DependencyNode dependencyNode2) {
        Iterator<DependencyNode> it = dependencyNode.targets.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next() != dependencyNode2) {
                i++;
            }
        }
        Iterator<DependencyNode> it2 = dependencyNode2.targets.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            if (it2.next() != dependencyNode) {
                i2++;
            }
        }
        return i > 0 && i2 > 0;
    }

    private void measure(ConstraintWidget constraintWidget, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour, int i, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2, int i2) {
        BasicMeasure$Measure basicMeasure$Measure = this.mMeasure;
        basicMeasure$Measure.horizontalBehavior = constraintWidget$DimensionBehaviour;
        basicMeasure$Measure.verticalBehavior = constraintWidget$DimensionBehaviour2;
        basicMeasure$Measure.horizontalDimension = i;
        basicMeasure$Measure.verticalDimension = i2;
        this.mMeasurer.measure(constraintWidget, basicMeasure$Measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private String nodeDefinition(WidgetRun widgetRun) {
        String strW;
        String strB;
        String strW2;
        boolean z2 = widgetRun instanceof VerticalWidgetRun;
        String debugName = widgetRun.widget.getDebugName();
        ConstraintWidget constraintWidget = widgetRun.widget;
        ConstraintWidget$DimensionBehaviour horizontalDimensionBehaviour = !z2 ? constraintWidget.getHorizontalDimensionBehaviour() : constraintWidget.getVerticalDimensionBehaviour();
        RunGroup runGroup = widgetRun.runGroup;
        String strW3 = a.w(a.w(a.w(!z2 ? a.w(debugName, "_HORIZONTAL") : a.w(debugName, "_VERTICAL"), " [shape=none, label=<"), "<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">"), "  <TR>");
        if (z2) {
            String strW4 = a.w(strW3, "    <TD ");
            if (widgetRun.start.resolved) {
                strW4 = a.w(strW4, " BGCOLOR=\"green\"");
            }
            strW = a.w(strW4, " PORT=\"TOP\" BORDER=\"1\">T</TD>");
        } else {
            String strW5 = a.w(strW3, "    <TD ");
            if (widgetRun.start.resolved) {
                strW5 = a.w(strW5, " BGCOLOR=\"green\"");
            }
            strW = a.w(strW5, " PORT=\"LEFT\" BORDER=\"1\">L</TD>");
        }
        String strW6 = a.w(strW, "    <TD BORDER=\"1\" ");
        boolean z3 = widgetRun.dimension.resolved;
        if (z3 && !widgetRun.widget.measured) {
            strW6 = a.w(strW6, " BGCOLOR=\"green\" ");
        } else if (z3 && widgetRun.widget.measured) {
            strW6 = a.w(strW6, " BGCOLOR=\"lightgray\" ");
        } else if (!z3 && widgetRun.widget.measured) {
            strW6 = a.w(strW6, " BGCOLOR=\"yellow\" ");
        }
        if (horizontalDimensionBehaviour == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
            strW6 = a.w(strW6, "style=\"dashed\"");
        }
        if (runGroup != null) {
            StringBuilder sbU = a.U(" [");
            sbU.append(runGroup.groupIndex + 1);
            sbU.append(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
            strB = a.B(sbU, RunGroup.index, "]");
        } else {
            strB = "";
        }
        String str = strW6 + ">" + debugName + strB + " </TD>";
        if (z2) {
            String strW7 = a.w(str, "    <TD ");
            if ((widgetRun instanceof VerticalWidgetRun) && ((VerticalWidgetRun) widgetRun).baseline.resolved) {
                strW7 = a.w(strW7, " BGCOLOR=\"green\"");
            }
            String strW8 = a.w(a.w(strW7, " PORT=\"BASELINE\" BORDER=\"1\">b</TD>"), "    <TD ");
            if (widgetRun.end.resolved) {
                strW8 = a.w(strW8, " BGCOLOR=\"green\"");
            }
            strW2 = a.w(strW8, " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>");
        } else {
            String strW9 = a.w(str, "    <TD ");
            if (widgetRun.end.resolved) {
                strW9 = a.w(strW9, " BGCOLOR=\"green\"");
            }
            strW2 = a.w(strW9, " PORT=\"RIGHT\" BORDER=\"1\">R</TD>");
        }
        return a.w(a.w(strW2, "  </TR></TABLE>"), ">];\n");
    }

    public void buildGraph() {
        buildGraph(this.mRuns);
        this.mGroups.clear();
        RunGroup.index = 0;
        findGroup(this.container.horizontalRun, 0, this.mGroups);
        findGroup(this.container.verticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void defineTerminalWidgets(ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2) {
        if (this.mNeedBuildGraph) {
            buildGraph();
            boolean z2 = false;
            for (ConstraintWidget constraintWidget : this.container.mChildren) {
                boolean[] zArr = constraintWidget.isTerminalWidget;
                zArr[0] = true;
                zArr[1] = true;
                if (constraintWidget instanceof Barrier) {
                    z2 = true;
                }
            }
            if (z2) {
                return;
            }
            for (RunGroup runGroup : this.mGroups) {
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                runGroup.defineTerminalWidgets(constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour3, constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3);
            }
        }
    }

    public boolean directMeasure(boolean z2) {
        boolean z3;
        boolean z4 = true;
        boolean z5 = z2 & true;
        if (this.mNeedBuildGraph || this.mNeedRedoMeasures) {
            for (ConstraintWidget constraintWidget : this.container.mChildren) {
                constraintWidget.ensureWidgetRuns();
                constraintWidget.measured = false;
                constraintWidget.horizontalRun.reset();
                constraintWidget.verticalRun.reset();
            }
            this.container.ensureWidgetRuns();
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            constraintWidgetContainer.measured = false;
            constraintWidgetContainer.horizontalRun.reset();
            this.container.verticalRun.reset();
            this.mNeedRedoMeasures = false;
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        ConstraintWidget$DimensionBehaviour dimensionBehaviour = this.container.getDimensionBehaviour(0);
        ConstraintWidget$DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(1);
        if (this.mNeedBuildGraph) {
            buildGraph();
        }
        int x2 = this.container.getX();
        int y2 = this.container.getY();
        this.container.horizontalRun.start.resolve(x2);
        this.container.verticalRun.start.resolve(y2);
        measureWidgets();
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour == constraintWidget$DimensionBehaviour || dimensionBehaviour2 == constraintWidget$DimensionBehaviour) {
            if (z5) {
                Iterator<WidgetRun> it = this.mRuns.iterator();
                while (it.hasNext()) {
                    if (!it.next().supportsWrapComputation()) {
                        z5 = false;
                        break;
                    }
                }
            }
            if (z5 && dimensionBehaviour == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) {
                this.container.setHorizontalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                constraintWidgetContainer2.setWidth(computeWrap(constraintWidgetContainer2, 0));
                ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                constraintWidgetContainer3.horizontalRun.dimension.resolve(constraintWidgetContainer3.getWidth());
            }
            if (z5 && dimensionBehaviour2 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) {
                this.container.setVerticalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                constraintWidgetContainer4.setHeight(computeWrap(constraintWidgetContainer4, 1));
                ConstraintWidgetContainer constraintWidgetContainer5 = this.container;
                constraintWidgetContainer5.verticalRun.dimension.resolve(constraintWidgetContainer5.getHeight());
            }
        }
        ConstraintWidgetContainer constraintWidgetContainer6 = this.container;
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = constraintWidgetContainer6.mListDimensionBehaviors;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviourArr[0];
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3 || constraintWidget$DimensionBehaviourArr[0] == ConstraintWidget$DimensionBehaviour.MATCH_PARENT) {
            int width = constraintWidgetContainer6.getWidth() + x2;
            this.container.horizontalRun.end.resolve(width);
            this.container.horizontalRun.dimension.resolve(width - x2);
            measureWidgets();
            ConstraintWidgetContainer constraintWidgetContainer7 = this.container;
            ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr2 = constraintWidgetContainer7.mListDimensionBehaviors;
            if (constraintWidget$DimensionBehaviourArr2[1] == constraintWidget$DimensionBehaviour3 || constraintWidget$DimensionBehaviourArr2[1] == ConstraintWidget$DimensionBehaviour.MATCH_PARENT) {
                int height = constraintWidgetContainer7.getHeight() + y2;
                this.container.verticalRun.end.resolve(height);
                this.container.verticalRun.dimension.resolve(height - y2);
            }
            measureWidgets();
            z3 = true;
        } else {
            z3 = false;
        }
        for (WidgetRun widgetRun : this.mRuns) {
            if (widgetRun.widget != this.container || widgetRun.resolved) {
                widgetRun.applyToWidget();
            }
        }
        for (WidgetRun widgetRun2 : this.mRuns) {
            if (z3 || widgetRun2.widget != this.container) {
                if (!widgetRun2.start.resolved || ((!widgetRun2.end.resolved && !(widgetRun2 instanceof GuidelineReference)) || (!widgetRun2.dimension.resolved && !(widgetRun2 instanceof ChainRun) && !(widgetRun2 instanceof GuidelineReference)))) {
                    z4 = false;
                    break;
                }
            }
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.container.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z4;
    }

    public boolean directMeasureSetup(boolean z2) {
        if (this.mNeedBuildGraph) {
            for (ConstraintWidget constraintWidget : this.container.mChildren) {
                constraintWidget.ensureWidgetRuns();
                constraintWidget.measured = false;
                HorizontalWidgetRun horizontalWidgetRun = constraintWidget.horizontalRun;
                horizontalWidgetRun.dimension.resolved = false;
                horizontalWidgetRun.resolved = false;
                horizontalWidgetRun.reset();
                VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
                verticalWidgetRun.dimension.resolved = false;
                verticalWidgetRun.resolved = false;
                verticalWidgetRun.reset();
            }
            this.container.ensureWidgetRuns();
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            constraintWidgetContainer.measured = false;
            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.horizontalRun;
            horizontalWidgetRun2.dimension.resolved = false;
            horizontalWidgetRun2.resolved = false;
            horizontalWidgetRun2.reset();
            VerticalWidgetRun verticalWidgetRun2 = this.container.verticalRun;
            verticalWidgetRun2.dimension.resolved = false;
            verticalWidgetRun2.resolved = false;
            verticalWidgetRun2.reset();
            buildGraph();
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        this.container.horizontalRun.start.resolve(0);
        this.container.verticalRun.start.resolve(0);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c5  */
    public boolean directMeasureWithOrientation(boolean z2, int i) {
        boolean z3;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        boolean z4 = true;
        boolean z5 = z2 & true;
        ConstraintWidget$DimensionBehaviour dimensionBehaviour = this.container.getDimensionBehaviour(0);
        ConstraintWidget$DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(1);
        int x2 = this.container.getX();
        int y2 = this.container.getY();
        if (z5 && (dimensionBehaviour == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour2 == constraintWidget$DimensionBehaviour)) {
            for (WidgetRun widgetRun : this.mRuns) {
                if (widgetRun.orientation == i && !widgetRun.supportsWrapComputation()) {
                    z5 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z5 && dimensionBehaviour == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setHorizontalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.FIXED);
                    ConstraintWidgetContainer constraintWidgetContainer = this.container;
                    constraintWidgetContainer.setWidth(computeWrap(constraintWidgetContainer, 0));
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                    constraintWidgetContainer2.horizontalRun.dimension.resolve(constraintWidgetContainer2.getWidth());
                }
            } else if (z5 && dimensionBehaviour2 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) {
                this.container.setVerticalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                constraintWidgetContainer3.setHeight(computeWrap(constraintWidgetContainer3, 1));
                ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                constraintWidgetContainer4.verticalRun.dimension.resolve(constraintWidgetContainer4.getHeight());
            }
        }
        if (i == 0) {
            ConstraintWidgetContainer constraintWidgetContainer5 = this.container;
            ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = constraintWidgetContainer5.mListDimensionBehaviors;
            if (constraintWidget$DimensionBehaviourArr[0] == ConstraintWidget$DimensionBehaviour.FIXED || constraintWidget$DimensionBehaviourArr[0] == ConstraintWidget$DimensionBehaviour.MATCH_PARENT) {
                int width = constraintWidgetContainer5.getWidth() + x2;
                this.container.horizontalRun.end.resolve(width);
                this.container.horizontalRun.dimension.resolve(width - x2);
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            ConstraintWidgetContainer constraintWidgetContainer6 = this.container;
            ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr2 = constraintWidgetContainer6.mListDimensionBehaviors;
            if (constraintWidget$DimensionBehaviourArr2[1] == ConstraintWidget$DimensionBehaviour.FIXED || constraintWidget$DimensionBehaviourArr2[1] == ConstraintWidget$DimensionBehaviour.MATCH_PARENT) {
                int height = constraintWidgetContainer6.getHeight() + y2;
                this.container.verticalRun.end.resolve(height);
                this.container.verticalRun.dimension.resolve(height - y2);
                z3 = true;
            } else {
                z3 = false;
            }
        }
        measureWidgets();
        for (WidgetRun widgetRun2 : this.mRuns) {
            if (widgetRun2.orientation == i && (widgetRun2.widget != this.container || widgetRun2.resolved)) {
                widgetRun2.applyToWidget();
            }
        }
        for (WidgetRun widgetRun3 : this.mRuns) {
            if (widgetRun3.orientation == i && (z3 || widgetRun3.widget != this.container)) {
                if (!widgetRun3.start.resolved || !widgetRun3.end.resolved || (!(widgetRun3 instanceof ChainRun) && !widgetRun3.dimension.resolved)) {
                    z4 = false;
                    break;
                }
            }
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.container.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z4;
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    public void measureWidgets() {
        DimensionDependency dimensionDependency;
        for (ConstraintWidget constraintWidget : this.container.mChildren) {
            if (!constraintWidget.measured) {
                ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
                boolean z2 = false;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviourArr[0];
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviourArr[1];
                int i = constraintWidget.mMatchConstraintDefaultWidth;
                int i2 = constraintWidget.mMatchConstraintDefaultHeight;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                boolean z3 = constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour3 || (constraintWidget$DimensionBehaviour == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && i == 1);
                if (constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3 || (constraintWidget$DimensionBehaviour2 == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1)) {
                    z2 = true;
                }
                DimensionDependency dimensionDependency2 = constraintWidget.horizontalRun.dimension;
                boolean z4 = dimensionDependency2.resolved;
                DimensionDependency dimensionDependency3 = constraintWidget.verticalRun.dimension;
                boolean z5 = dimensionDependency3.resolved;
                if (z4 && z5) {
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.FIXED;
                    measure(constraintWidget, constraintWidget$DimensionBehaviour4, dimensionDependency2.value, constraintWidget$DimensionBehaviour4, dimensionDependency3.value);
                    constraintWidget.measured = true;
                } else if (z4 && z2) {
                    measure(constraintWidget, ConstraintWidget$DimensionBehaviour.FIXED, dimensionDependency2.value, constraintWidget$DimensionBehaviour3, dimensionDependency3.value);
                    if (constraintWidget$DimensionBehaviour2 == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.verticalRun.dimension.wrapValue = constraintWidget.getHeight();
                    } else {
                        constraintWidget.verticalRun.dimension.resolve(constraintWidget.getHeight());
                        constraintWidget.measured = true;
                    }
                } else if (z5 && z3) {
                    measure(constraintWidget, constraintWidget$DimensionBehaviour3, dimensionDependency2.value, ConstraintWidget$DimensionBehaviour.FIXED, dimensionDependency3.value);
                    if (constraintWidget$DimensionBehaviour == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.horizontalRun.dimension.wrapValue = constraintWidget.getWidth();
                    } else {
                        constraintWidget.horizontalRun.dimension.resolve(constraintWidget.getWidth());
                        constraintWidget.measured = true;
                    }
                }
                if (constraintWidget.measured && (dimensionDependency = constraintWidget.verticalRun.baselineDimension) != null) {
                    dimensionDependency.resolve(constraintWidget.getBaselineDistance());
                }
            }
        }
    }

    public void setMeasurer(BasicMeasure$Measurer basicMeasure$Measurer) {
        this.mMeasurer = basicMeasure$Measurer;
    }

    public void buildGraph(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        arrayList.add(this.mContainer.horizontalRun);
        arrayList.add(this.mContainer.verticalRun);
        HashSet hashSet = null;
        for (ConstraintWidget constraintWidget : this.mContainer.mChildren) {
            if (constraintWidget instanceof Guideline) {
                arrayList.add(new GuidelineReference(constraintWidget));
            } else {
                if (constraintWidget.isInHorizontalChain()) {
                    if (constraintWidget.horizontalChainRun == null) {
                        constraintWidget.horizontalChainRun = new ChainRun(constraintWidget, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.horizontalChainRun);
                } else {
                    arrayList.add(constraintWidget.horizontalRun);
                }
                if (constraintWidget.isInVerticalChain()) {
                    if (constraintWidget.verticalChainRun == null) {
                        constraintWidget.verticalChainRun = new ChainRun(constraintWidget, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.verticalChainRun);
                } else {
                    arrayList.add(constraintWidget.verticalRun);
                }
                if (constraintWidget instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(constraintWidget));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        for (WidgetRun widgetRun : arrayList) {
            if (widgetRun.widget != this.mContainer) {
                widgetRun.apply();
            }
        }
    }
}
