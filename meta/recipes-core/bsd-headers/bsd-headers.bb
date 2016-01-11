# Copyright (C) 2016 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "bsd compatible headers"
LICENSE = "BSD-3-Clause && BSD-2-Clause"
SECTION = "devel"

SRC_URI = "file://sys-queue.h \
           file://sys-tree.h \
           file://sys-cdefs.h \
          "
do_configure[noexec] = "1"
do_compile[noexec] = "1"

INHIBIT_DEFAULT_DEPS = "1"

S = "${WORKDIR}"

do_install() {
	install -Dm 0644 ${S}/sys-queue.h ${D}${includedir}/sys/queue.h
	install -Dm 0644 ${S}/sys-tree.h ${D}${includedir}/sys/tree.h
	install -Dm 0644 ${S}/sys-cdefs.h ${D}${includedir}/sys/cdefs.h
}
#
# We will skip parsing for non-musl systems
#
COMPATIBLE_HOST = ".*-musl.*"
