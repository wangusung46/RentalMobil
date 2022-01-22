/*
 * Copyright (c) 2022 Rakha.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Rakha - initial API and implementation and/or initial documentation
 */
package rentalmobil.jdbc;

import java.util.List;
import rentalmobil.model.JenisMobil;

/**
 *
 * @author Rakha
 */
public interface JenisMobilJdbc {
    
    public abstract List<JenisMobil> selectJenisMobils();
}
