/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2019 Serge Rider (serge@jkiss.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.ui.dashboard.control;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.jkiss.dbeaver.model.DBPDataSourceContainer;
import org.jkiss.dbeaver.model.DBPDataSourceProvider;
import org.jkiss.dbeaver.model.IDataSourceContainerProvider;
import org.jkiss.dbeaver.model.IDataSourceContainerProviderEx;
import org.jkiss.dbeaver.ui.dashboard.registry.DashboardDescriptor;
import org.jkiss.dbeaver.ui.dashboard.registry.DashboardRegistry;

import java.util.List;

public class DashboardList extends Composite {

    private IDataSourceContainerProvider provider;

    public DashboardList(Composite parent, IDataSourceContainerProvider provider) {
        super(parent, SWT.NONE);

        this.provider = provider;

        RowLayout layout = new RowLayout();
        layout.wrap = true;
        layout.spacing = 5;
        this.setLayout(layout);
    }

    DBPDataSourceContainer getDataSourceContainer() {
        return provider.getDataSourceContainer();
    }

    void createDefaultDashboards() {
        List<DashboardDescriptor> dashboards = DashboardRegistry.getInstance().getDashboards(provider.getDataSourceContainer(), true);
        for (DashboardDescriptor dd : dashboards) {
            DashboardItem item = new DashboardItem(this, dd);
        }
    }

}
