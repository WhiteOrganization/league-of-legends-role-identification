@echo off
setlocal enabledelayedexpansion

set HOOKS_FOLDER=.git\hooks
set HOOK_FILE=%HOOKS_FOLDER%\pre-push

echo #^^!/bin/bash > %HOOK_FILE%
echo. >> %HOOK_FILE%
echo protected_branches=("main" "master" "development") >> %HOOK_FILE%
echo. >> %HOOK_FILE%
echo while read -r local_ref local_sha remote_ref remote_sha >> %HOOK_FILE%
echo do >> %HOOK_FILE%
echo   for branch in "${protected_branches[@]}" >> %HOOK_FILE%
echo   do >> %HOOK_FILE%
echo       if ^[^[ ^$remote_ref == refs/heads/^$branch ^]^] >> %HOOK_FILE%
echo       then >> %HOOK_FILE%
echo.         echo ^>^&2 "Pushing to branch $branch is not allowed. To push to this branch:" >> %HOOK_FILE%
echo.         echo ^>^&2 "1) Stash your changes: 'git stash'" >> %HOOK_FILE%
echo.         echo ^>^&2 "2) Create and checkout a new branch: 'git checkout -b new-branch'" >> %HOOK_FILE%
echo.         echo ^>^&2 "3) Apply the stashed changes to the new branch: 'git stash apply'" >> %HOOK_FILE%
echo.         echo ^>^&2 "4) Then push from there and generate a Pull Request to this branch." >> %HOOK_FILE%
echo          exit 1 >> %HOOK_FILE%
echo       fi >> %HOOK_FILE%
echo     done >> %HOOK_FILE%
echo done >> %HOOK_FILE%
echo exit 0 >> %HOOK_FILE%

echo Created pre-push hook successfully, your branch is protected from yourself now :D
pause
exit

REM endlocal
