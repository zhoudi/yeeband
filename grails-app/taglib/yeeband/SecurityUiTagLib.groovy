/* Copyright 2009-2013 SpringSource.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package yeeband

import org.apache.commons.lang.StringUtils

/**
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
class SecurityUiTagLib extends grails.plugin.springsecurity.ui.SecurityUiTagLib{


    def submitButton = { attrs ->
        String form = getRequiredAttribute(attrs, 'form', 'submitButton')
        String elementId = getRequiredAttribute(attrs, 'elementId', 'submitButton')
        String text = resolveText(attrs)

        def writer = getOut()
//        writer << """<a id="${elementId}" """
//        writeRemainingAttributes writer, attrs
//        writer << ">${text}</a>\n"
        writer << "<input type='submit' value='${text}' id='${elementId}_submit' class='btn btn-primary' />\n"

        String javascript = """
			\$("#${elementId}").button();
			\$('#${elementId}').bind('click', function() {
			   document.forms.${form}.submit();
			});
		"""
        writeDocumentReady writer, javascript
    }

    def form = { attrs, body ->
        boolean center = attrs.remove('center') == 'true'
        boolean resizeable = attrs.remove('resizeable') != 'false'
        def width = getRequiredAttribute(attrs, 'width', 'form')
        if (width.endsWith('%')) {
            center = true
            resizeable = true
        }
        else {
            width = width.toInteger().toString() + 'px'
        }
        int height = getRequiredAttribute(attrs, 'height', 'form').toInteger()
        String titleCode = getRequiredAttribute(attrs, 'titleCode', 'form')
        def titleCodeArgs = attrs.remove('titleCodeArgs')
        String elementId = getRequiredAttribute(attrs, 'elementId', 'form')

        String classes = getRequiredAttribute(attrs, 'class', 'form')
        if (StringUtils.isBlank(classes)) {
            classes = "ui-widget-content"
        }
        if (center) classes += ' s2ui_center'

        String title = titleCodeArgs ? message(code: titleCode, args: titleCodeArgs) : message(code: titleCode)

        out << """
		<div class="$classes" id="${elementId}"
		     style="width: ${width}; height: ${height}px; padding: 5px; text-align: center; position: relative;">

		<div class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix s2ui_center" style='padding: 10px'>
		<span style="-moz-user-select: none;" unselectable="on" class="ui-dialog-title">
		${title}
		</span>
		</div>

		${body()}

		</div>
		"""

        if (resizeable) {
            writeDocumentReady out, "\$('#${elementId}').resizable();"
        }
    }
}
