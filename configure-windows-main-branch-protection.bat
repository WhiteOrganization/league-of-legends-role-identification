@echo off
REM Navigate to the .git/hooks directory
cd .git\hooks

REM Create the pre-push hook script
echo @echo off > pre-push
echo for /F "tokens=2" %%%%a in ('git branch --show-current') do set current_branch=%%%%a >> pre-push
echo if "%%current_branch%%"=="main" goto :block >> pre-push
echo if "%%current_branch%%"=="master" goto :block >> pre-push
echo if "%%current_branch%%"=="development" goto :block >> pre-push
echo exit /b 0 >> pre-push
echo :block >> pre-push
echo echo Push to %%current_branch%% is not allowed. Please follow these steps to move your changes to a new branch: >> pre-push
echo echo 1. Stash your changes: git stash >> pre-push
echo echo 2. Create and checkout a new branch: git checkout -b new-branch >> pre-push
echo echo 3. Apply the stashed changes to the new branch: git stash apply >> pre-push
echo exit /b 1 >> pre-push
